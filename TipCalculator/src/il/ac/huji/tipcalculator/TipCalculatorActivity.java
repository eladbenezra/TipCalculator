package il.ac.huji.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
	
	private EditText _editText;
	private CheckBox _checkBox;
	private TextView _textView;
	private double tipPercentage = 12.0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        this._editText = (EditText)findViewById(R.id.edtBillAmount);
        this._checkBox = (CheckBox)findViewById(R.id.chkRound);
        this._textView = (TextView)findViewById(R.id.txtTipResult);
    }

    public void calculateTip(View view){
    	double totalBill = Double.parseDouble((this._editText.getText().toString()));
    	double tip = (totalBill * this.tipPercentage)/100.0;
    	boolean checkRound = this._checkBox.isChecked();
    	if(!checkRound){
    		DecimalFormat format = new DecimalFormat("#.##");
    		format.setMinimumFractionDigits(2);
    		this._textView.setText("$"+format.format(tip));
    	}
    	else{
    		int tipo = (int) Math.round(tip);
    		this._textView.setText("$"+Integer.toString(tipo));
    	}
    }

    
}
