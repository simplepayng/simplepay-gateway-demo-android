package ng.simplepay.gateway.checkout.demo.democheckout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final Integer SIMPLEPAY_GATEWAY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button payBtn = (Button) findViewById(R.id.payBtn);
        payBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ng.simplepay.gateway.Gateway.class);
                myIntent.putExtra("api_key", "test_pu_demo");
                myIntent.putExtra("description", "Order #123-45678 and a very long description");
                myIntent.putExtra("amount", 1000);
                myIntent.putExtra("amount_currency", "NGN");
                myIntent.putExtra("email", "a@a.com");
                myIntent.putExtra("phone", "+351911111111");
                myIntent.putExtra("payment_type", "checkout");
                myIntent.putExtra("address", "31 Kade St, Abuja, Nigeria");
                myIntent.putExtra("postal_code", "110001");
                myIntent.putExtra("state", "Abuja");
                myIntent.putExtra("country", "NG");
                MainActivity.this.startActivityForResult(myIntent, SIMPLEPAY_GATEWAY);
            }
        });

        final Button payBtnRemember = (Button) findViewById(R.id.payBtnRemember);
        payBtnRemember.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ng.simplepay.gateway.Gateway.class);
                myIntent.putExtra("api_key", "test_pu_demo");
                myIntent.putExtra("description", "Order #123-45678 and a very long description");
                myIntent.putExtra("amount", 1000);
                myIntent.putExtra("amount_currency", "NGN");
                myIntent.putExtra("email", "a@a.com");
                myIntent.putExtra("phone", "+351911111111");
                myIntent.putExtra("payment_type", "remember");
                myIntent.putExtra("address", "31 Kade St, Abuja, Nigeria");
                myIntent.putExtra("postal_code", "110001");
                myIntent.putExtra("state", "Abuja");
                myIntent.putExtra("country", "NG");
                MainActivity.this.startActivityForResult(myIntent, SIMPLEPAY_GATEWAY);
            }
        });

        final Button payBtnUserData = (Button) findViewById(R.id.payBtnUserData);
        payBtnUserData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ng.simplepay.gateway.Gateway.class);
                myIntent.putExtra("api_key", "test_pu_demo");
                myIntent.putExtra("description", "Order #123-45678 and a very long description");
                myIntent.putExtra("amount", 1000);
                myIntent.putExtra("amount_currency", "NGN");
                myIntent.putExtra("payment_type", "checkout");
                myIntent.putExtra("address", "31 Kade St, Abuja, Nigeria");
                myIntent.putExtra("postal_code", "110001");
                myIntent.putExtra("state", "Abuja");
                myIntent.putExtra("country", "NG");
                MainActivity.this.startActivityForResult(myIntent, SIMPLEPAY_GATEWAY);
            }
        });

        final Button payBtnFail = (Button) findViewById(R.id.payBtnFail);
        payBtnFail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ng.simplepay.gateway.Gateway.class);
                MainActivity.this.startActivityForResult(myIntent, SIMPLEPAY_GATEWAY);
            }
        });

        final Button payBtnCustomImage = (Button) findViewById(R.id.payBtnCustomImage);
        payBtnCustomImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ng.simplepay.gateway.Gateway.class);
                myIntent.putExtra("api_key", "test_pu_demo");
                myIntent.putExtra("description", "Order #123-45678 and a very long description");
                myIntent.putExtra("amount", 1000);
                myIntent.putExtra("amount_currency", "NGN");
                myIntent.putExtra("email", "a@a.com");
                myIntent.putExtra("phone", "+351911111111");
                myIntent.putExtra("payment_type", "checkout");
                myIntent.putExtra("logo", "https://secure.gravatar.com/avatar/c161f5d7024dc7a5c662033db3c397c3?s=140&d=identicon");
                MainActivity.this.startActivityForResult(myIntent, SIMPLEPAY_GATEWAY);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SIMPLEPAY_GATEWAY && resultCode == Activity.RESULT_OK) {
            String token = data.getStringExtra("token");
            TextView resultTxt = (TextView) findViewById(R.id.resultTxt);
            resultTxt.setText(token);
        }
    }

}
