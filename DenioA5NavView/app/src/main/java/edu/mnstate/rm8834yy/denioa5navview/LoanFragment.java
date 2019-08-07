package edu.mnstate.rm8834yy.denioa5navview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoanFragment extends Fragment {
    private EditText rateTxt;
    private EditText amountTxt;
    private EditText yearsTxt;
    private Button submitBtn;
    private EditText table;

    private BigDecimal rate;
    private BigDecimal amount;
    private int years;

    private BigDecimal monthlyP;
    private BigDecimal totalP;
    private BigDecimal intPayed;

    private String strOut;





    public LoanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loan, container, false);

        rateTxt = (EditText) view.findViewById(R.id.rateTxt);
        amountTxt = (EditText) view.findViewById(R.id.amountTxt);
        yearsTxt = (EditText) view .findViewById(R.id.yearsTxt);
        submitBtn = (Button) view.findViewById(R.id.submitBtn);
        table = (EditText) view.findViewById(R.id.table);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rate = new BigDecimal(rateTxt.getText().toString());
                amount = new BigDecimal(amountTxt.getText().toString());
                years = Integer.valueOf(yearsTxt.getText().toString());

                monthlyP = calcMonthly(rate,amount,years);
                totalP = totalPayment(rate,amount,years);
                intPayed = totalInterest(rate,amount,years);

                strOut = "Interest Rate:"+ rate.toString()+ "    "+"Total Pmt: "+ totalP.toString()
                +"\n"
                +"Monthly Pmt: "+ monthlyP.toString()+"     "+"Total Interest Paid: "+intPayed.toString()
                +"\n"+
                "-----------------------------------------------------------------------";

                table.setText(strOut);
            }
        });

    return view;
    }

    private BigDecimal calcMonthly(BigDecimal tmpRate, BigDecimal tmpAmt,int tmpYears) {
        BigDecimal top = tmpRate.multiply(tmpAmt);
        BigDecimal one = new BigDecimal("1");
        BigDecimal tmpNum = tmpRate.add(one);
        int numMonthes = -1 * tmpYears * 12 ;
        tmpNum = tmpNum.pow(numMonthes);
        tmpNum = one.subtract(tmpNum);
        tmpNum = top.divide(tmpNum);
        return tmpNum;
    }
    private  BigDecimal totalPayment(BigDecimal tmpRate, BigDecimal tmpAmt,int tmpYears){
        int monthes = tmpYears*12;
        BigDecimal numMonthes = new BigDecimal(Integer.toString(monthes));
        BigDecimal num;
        BigDecimal monthly = calcMonthly(tmpRate,tmpAmt,tmpYears);
        num = monthly.multiply(numMonthes);

        return num;

    }

    private  BigDecimal totalInterest(BigDecimal tmpRate, BigDecimal tmpAmt,int tmpYears){
        BigDecimal total = totalPayment(tmpRate,tmpAmt,tmpYears);
        BigDecimal interest = total.subtract(tmpAmt);

        return interest;

    }

}
