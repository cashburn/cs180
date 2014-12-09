package edu.purdue.cashburn;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SubmitCallbackListener,
		StartOverCallbackListener {

	/**
	 * The ClientFragment used by the activity.
	 */
	private ClientFragment clientFragment;

	/**
	 * The ServerFragment used by the activity.
	 */
	private ServerFragment serverFragment;

	/**
	 * UI component of the ActionBar used for navigation.
	 */
	private Button left;
	private Button right;
	private TextView title;

	/**
	 * Called once the activity is created.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_layout);

		this.clientFragment = ClientFragment.newInstance(this);
		this.serverFragment = ServerFragment.newInstance();

		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.add(R.id.fl_main, this.clientFragment);
		ft.commit();
	}

	/**
	 * Creates the ActionBar: - Inflates the layout - Extracts the components
	 */
	@SuppressLint("InflateParams")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater()
				.inflate(R.layout.action_bar, null);

		// Set up the ActionBar
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(actionBarLayout);

		// Extract the UI component.
		this.title = (TextView) actionBarLayout.findViewById(R.id.tv_title);
		this.left = (Button) actionBarLayout.findViewById(R.id.bu_left);
		this.right = (Button) actionBarLayout.findViewById(R.id.bu_right);
		this.right.setVisibility(View.INVISIBLE);

		return true;
	}

	/**
	 * Callback function called when the user click on the right button of the
	 * ActionBar.
	 * 
	 * @param v
	 */
	public void onRightClick(View v) {
		FragmentTransaction ft = getFragmentManager().beginTransaction();

		this.title.setText(this.getResources().getString(R.string.client));
		this.left.setVisibility(View.VISIBLE);
		this.right.setVisibility(View.INVISIBLE);
		ft.replace(R.id.fl_main, this.clientFragment);
		ft.commit();
	}

	/**
	 * Callback function called when the user click on the left button of the
	 * ActionBar.
	 * 
	 * @param v
	 */
	public void onLeftClick(View v) {
		FragmentTransaction ft = getFragmentManager().beginTransaction();

		this.title.setText(this.getResources().getString(R.string.server));
		this.left.setVisibility(View.INVISIBLE);
		this.right.setVisibility(View.VISIBLE);
		ft.replace(R.id.fl_main, this.serverFragment);
		ft.commit();

	}

	/**
	 * Callback function called when the user click on the submit button.
	 */
	@Override
	public void onSubmit() {
		String getName = this.clientFragment.getName();
		String getFrom = this.clientFragment.getFrom();
		String getTo = this.clientFragment.getTo();
		String getType = Integer.toString(this.clientFragment.getType());
		if ((getName == null) || getName.equals("")) {
			AlertDialog alertDialog = new AlertDialog.Builder(
					this).create();
			alertDialog.setTitle("Error");
			alertDialog.setMessage("Please enter a valid name (no commas).");
			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {	
				}
			});
			alertDialog.show();
			return;
		}
		if (getFrom.equals(getTo)) {
			AlertDialog alertDialog = new AlertDialog.Builder(
					this).create();
			alertDialog.setTitle("Error");
			alertDialog.setMessage("FROM cannot be the same as TO.");
			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {	
				}
			});
			alertDialog.show();
			return;
		}
		if (getTo.equals("*") && (!getType.equals("2"))) {
			AlertDialog alertDialog = new AlertDialog.Builder(
					this).create();
			alertDialog.setTitle("Error");
			alertDialog.setMessage("Must be a volunteer to have 'No Preference' for TO.");
			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {	
				}
			});
			alertDialog.show();
			return;
		}
		// Server info
		String host = this.serverFragment.getHost(getResources().getString(
				R.string.default_host));
		int port;
		try {
			port = this.serverFragment.getPort(Integer.parseInt(getResources()
				.getString(R.string.default_port)));
		}
		catch (NumberFormatException e) {
			AlertDialog alertDialog = new AlertDialog.Builder(
					this).create();
			alertDialog.setTitle("Error");
			alertDialog.setMessage("Please enter a valid port number between 1 and 65535.");
			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {	
				}
			});
			alertDialog.show();
			return;
		}
		String command = getName + "," + getFrom + "," + getTo + "," + getType;
		if ((host == null) || host.equals("") || host.contains(" ")) {
			AlertDialog alertDialog = new AlertDialog.Builder(
					this).create();
			alertDialog.setTitle("Error");
			alertDialog.setMessage("Please enter a valid host (no spaces).");
			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {	
				}
			});
			alertDialog.show();
			return;
		}
		if ((port < 1) || port > 65535) {
			AlertDialog alertDialog = new AlertDialog.Builder(
					this).create();
			alertDialog.setTitle("Error");
			alertDialog.setMessage("Please enter a valid port number between 1 and 65535.");
			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {	
				}
			});
			alertDialog.show();
			return;
		}
		FragmentTransaction ft = getFragmentManager().beginTransaction();

		this.title.setText(getResources().getString(R.string.match));
		this.left.setVisibility(View.INVISIBLE);
		this.right.setVisibility(View.INVISIBLE);


		MatchFragment frag = MatchFragment.newInstance(this, host, port,
				command);

		ft.replace(R.id.fl_main, frag);
		ft.commit();
	}

	/**
	 * Callback function call from MatchFragment when the user want to create a
	 * new request.
	 */
	@Override
	public void onStartOver() {
		onRightClick(null);
	}

	public void onRadioButtonClicked(View view) {
		this.clientFragment.onRadioButtonClicked(view);
	}
}
