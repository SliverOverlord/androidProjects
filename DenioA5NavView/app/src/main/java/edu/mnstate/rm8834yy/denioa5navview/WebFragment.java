package edu.mnstate.rm8834yy.denioa5navview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebFragment extends Fragment {
    private EditText webTxt;
    private WebView webV;


    public WebFragment() {
        // Required empty public constructor
    }

    public void onCreat(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_web, container, false);

        webTxt = (EditText) view.findViewById(R.id.webTxt);
        webV = (WebView) view.findViewById(R.id.webV);

        webV.setWebViewClient(new WebViewClient());
        webV.loadUrl(webTxt.getText().toString());
        webTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (webTxt.getText().toString().contains("https://")
                        && (webTxt.getText().toString().contains(".com"))
                        || webTxt.getText().toString().contains(".net")
                        ||webTxt.getText().toString().contains(".org")
                        ||webTxt.getText().toString().contains(".edu")
                        ||webTxt.getText().toString().contains(".gov"))
                    webV.loadUrl(webTxt.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }

}
