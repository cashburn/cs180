package edu.purdue.cashburn;

import java.io.Closeable;

import android.app.Fragment;
import android.database.CursorJoiner.Result;
import android.util.Log;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

/**
 * This fragment is the "page" where the application display the log from the
 * server and wait for a match.
 *
 * @author YL
 */
public class MatchFragment extends Fragment implements OnClickListener {

	private static final String DEBUG_TAG = "DEBUG";

	/**
	 * Activity which have to receive callbacks.
	 */
	private StartOverCallbackListener activity;

	/**
	 * AsyncTask sending the request to the server.
	 */
	private Client client;

	/**
	 * Coordinate of the server.
	 */
	private String host;
	private int port;

	/**
	 * Command the user should send.
	 */
	private String command;

	// TODO: your own class fields here

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private String response;
	private TextView matchPartnerResult;
	private TextView matchFromResult;
	private TextView matchToResult;
	private TextView matchTo;
	private TextView matchFrom;
	private TextView matchPartner;
	private String partner;
	private String to;
	private String from;
	private TextView log;
	private String tempLog;
	private SimpleDateFormat timeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss ", Locale.US);
	// Class methods
	/**
	 * Creates a MatchFragment
	 * 
	 * @param activity
	 *            activity to notify once the user click on the start over
	 *            Button.
	 * @param host
	 *            address or IP address of the server.
	 * @param port
	 *            port number.
	 * 
	 * @param command
	 *            command you have to send to the server.
	 * 
	 * @return the fragment initialized.
	 */

	// ** DO NOT CREATE A CONSTRUCTOR FOR MatchFragment **
	public static MatchFragment newInstance(StartOverCallbackListener activity,
			String host, int port, String command) {
		MatchFragment f = new MatchFragment();

		f.activity = activity;
		f.host = host;
		f.port = port;
		f.command = command;

		return f;
	}

	/**
	 * Called when the fragment will be displayed.
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		View view = inflater.inflate(R.layout.match_fragment_layout, container,
				false);
		matchPartnerResult = (TextView) view.findViewById(R.id.match_partner_result);
		matchFromResult = (TextView) view.findViewById(R.id.match_from_result);
		matchToResult = (TextView) view.findViewById(R.id.match_to_result);
		matchPartner = (TextView) view.findViewById(R.id.match_partner);
		matchFrom = (TextView) view.findViewById(R.id.match_from);
		matchTo = (TextView) view.findViewById(R.id.match_to);
		log = (TextView) view.findViewById(R.id.log);
		/**
		 * Register this fragment to be the OnClickListener for the startover
		 * button.
		 */
		view.findViewById(R.id.bu_start_over).setOnClickListener(this);


		/**
		 * Launch the AsyncTask
		 */
		this.client = new Client();
		this.client.execute("");

		return view;
	}

	/**
	 * Callback function for the OnClickListener interface.
	 */
	@Override
	public void onClick(View v) {
		this.client.cancel(true);
		/**
		 * Close the AsyncTask if still running.
		 */
		//this.client.close();

		/**
		 * Notify the Activity.
		 */
		this.activity.onStartOver();
	}
	
	class Client extends AsyncTask<String, String, String> implements Closeable {

		/**
		 * NOTE: you can access MatchFragment field from this class:
		 * 
		 * Example: The statement in doInBackground will print the message in
		 * the Eclipse LogCat view.
		 */

		/**
		 * The system calls this to perform work in a worker thread and delivers
		 * it the parameters given to AsyncTask.execute()
		 */
		protected String doInBackground(String... params) {

			/**
			 * TODO: Your Client code here.
			 */
			try {
				socket = new Socket(host, port);
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				tempLog = "Connection to the server. Success.";
				publishProgress();
				try {
				Thread.sleep(100);
				}
				catch (InterruptedException e) {
				}
				out.println(command);
				tempLog = "Waiting on response from server...";
				publishProgress();
				while ((response == null) && !isCancelled())
					response = in.readLine();
			}
			catch (UnknownHostException e) {				
				tempLog = "The server is not available.";
				publishProgress();
				Log.d(DEBUG_TAG, String.format("Error connecting to server: %s!", host));
				return "";
			}
			catch (ConnectException e) {
				tempLog = "The server is not available.";
				publishProgress();
				Log.d(DEBUG_TAG, String.format("Error connecting to server: %s!", host));
				return "";
			}
			catch (IOException e) {
				Log.d(DEBUG_TAG, e.toString());
			}
			
			Log.d(DEBUG_TAG, String
					.format("The Server at the address %s uses the port %d",
							host, port));

			Log.d(DEBUG_TAG, String.format(
					"The Client will send the command: %s", command));

			if ((response != null) && !isCancelled()) {
				if (response.startsWith("RESPONSE: ")) {
					out.println(":ACK");
					tempLog = "A pair has been found by the server.";
					publishProgress();
					partner = response.substring(response.indexOf(' ') + 1);
					from = partner.substring(partner.indexOf(',') + 1);
					to = from.substring(from.indexOf(',') + 1);
					from = from.substring(0,from.indexOf(','));
					to = to.substring(0,to.indexOf(','));
					partner = partner.substring(0,partner.indexOf(','));
					//publishProgress();
				}
			}
			close();
			return "";
		}
		public void close() {
                    // TODO: Clean up the client
			try {
				socket.close();
				out.close();
				in.close();
			}
			catch (IOException e) {
				Log.d(DEBUG_TAG, e.toString());
			}
			
		}

		/**
		 * The system calls this to perform work in the UI thread and delivers
		 * the result from doInBackground()
		 */

		// TODO: use the following method to update the UI.
		// ** DO NOT TRY TO CALL UI METHODS FROM doInBackground!!!!!!!!!! **

		/**
		 * Method executed just before the task.
		 */
		@Override
		protected void onPreExecute() {
			log.setText("");
			matchPartnerResult.setVisibility(View.INVISIBLE);
			matchFromResult.setVisibility(View.INVISIBLE);
			matchToResult.setVisibility(View.INVISIBLE);
			matchPartner.setVisibility(View.INVISIBLE);
			matchFrom.setVisibility(View.INVISIBLE);
			matchTo.setVisibility(View.INVISIBLE);
		}

		/**
		 * Method executed once the task is completed.
		 */
		@Override
		protected void onPostExecute(String result) {
			matchPartnerResult.setText(partner);
			matchFromResult.setText(from);
			matchToResult.setText(to);
			matchPartnerResult.setVisibility(View.VISIBLE);
			matchFromResult.setVisibility(View.VISIBLE);
			matchToResult.setVisibility(View.VISIBLE);
			matchPartner.setVisibility(View.VISIBLE);
			matchFrom.setVisibility(View.VISIBLE);
			matchTo.setVisibility(View.VISIBLE);
		}

		/**
		 * Method executed when progressUpdate is called in the doInBackground
		 * function.
		 */
		@Override
		protected void onProgressUpdate(String... result) {
			String timestamp = timeFormat.format(new Date());
			log.append("\n" +"[" + timestamp + "] " + tempLog);
			
		}
	}

}
