package edu.purdue.cashburn;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

/**
 * This fragment is the "page" where the user inputs information about the
 * request, he/she wishes to send.
 *
 * @author YL
 */
public class ClientFragment extends Fragment implements OnClickListener {

	/**
	 * Activity which have to receive callbacks.
	 */
	private SubmitCallbackListener activity;

	
	//private RadioButton radio0;
	//private RadioButton radio1;
	//private RadioButton radio2;
	private EditText name;
	private int type;
	private Spinner fromField;
	private Spinner toField;
	/**
	 * Creates a ProfileFragment
	 * 
	 * @param activity
	 *            activity to notify once the user click on the submit Button.
	 * 
	 *            ** DO NOT CREATE A CONSTRUCTOR FOR MatchFragment **
	 * 
	 * @return the fragment initialized.
	 */
	// ** DO NOT CREATE A CONSTRUCTOR FOR ProfileFragment **
	public static ClientFragment newInstance(SubmitCallbackListener activity) {
		ClientFragment f = new ClientFragment();

		f.activity = activity;
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

		View view = inflater.inflate(R.layout.client_fragment_layout,
				container, false);

		/**
		 * Register this fragment to be the OnClickListener for the submit
		 * Button.
		 */
		view.findViewById(R.id.bu_submit).setOnClickListener(this);

		this.name = (EditText) view.findViewById(R.id.et_name);
		
		fromField = (Spinner) view.findViewById(R.id.spinner1);
		toField = (Spinner) view.findViewById(R.id.spinner2);
		
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
		        R.array.locations_array1, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
		        R.array.locations_array2, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		toField.setAdapter(adapter1);
		fromField.setAdapter(adapter2);

		return view;
	}

	/**
	 * Callback function for the OnClickListener interface.
	 */
	@Override
	public void onClick(View v) {
		this.activity.onSubmit();
	}
	
	public String getName() {
		String getName = name.getText().toString();
		if ((getName != null) && (getName.indexOf(",") == -1))
			return getName;
		return null;
	}
	public String getFrom() {
		String getFrom = this.fromField.getSelectedItem().toString();
		return getFrom.substring(0,getFrom.indexOf("-"));
	}
	public String getTo() {
		String getTo = this.toField.getSelectedItem().toString();
		if (getTo.contains("No "))
			return "*";
		return getTo.substring(0,getTo.indexOf("-"));
	}
	public int getType() {
		return type;
	}
	
	public void onRadioButtonClicked(View view) {
	    boolean checked = ((RadioButton) view).isChecked();
	    switch(view.getId()) {
	        case R.id.radioButton1:
	            if (checked)
	                type = 1;
	            break;
	        case R.id.radioButton2:
	            if (checked)
	                type = 2;
	            break;
	        case R.id.radioButton0:
	        	if (checked)
	        		type = 0;
	        	break;
	        	
	    }
	}
}