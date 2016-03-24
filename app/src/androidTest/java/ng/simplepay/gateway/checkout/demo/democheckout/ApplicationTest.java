package ng.simplepay.gateway.checkout.demo.democheckout;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import ng.simplepay.gateway.checkout.Checkout;

public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private Button payBtn;
    private Button payBtnUserData;
    private Button payBtnFail;
    private Button payBtnCustomImage;

    private Instrumentation.ActivityMonitor checkoutActivityMonitor;

    public ApplicationTest() {
        super(MainActivity.class);
    }

    public void testOpenCheckoutActivity() {
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                payBtn.performClick();
            }
        });
        Checkout checkoutActivity = (Checkout) checkoutActivityMonitor.waitForActivity();
        assertNotNull("Target Activity is not launched", checkoutActivity);
        checkoutActivity.finish();

        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                payBtnUserData.performClick();
            }
        });
        checkoutActivity = (Checkout) checkoutActivityMonitor.waitForActivity();
        assertNotNull("Target Activity is not launched", checkoutActivity);
        checkoutActivity.finish();

        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                payBtnFail.performClick();
            }
        });
        checkoutActivity = (Checkout) checkoutActivityMonitor.waitForActivity();
        assertNotNull("Target Activity is not launched", checkoutActivity);
        checkoutActivity.finish();

        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                payBtnCustomImage.performClick();
            }
        });
        checkoutActivity = (Checkout) checkoutActivityMonitor.waitForActivity();
        assertNotNull("Target Activity is not launched", checkoutActivity);
        checkoutActivity.finish();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        checkoutActivityMonitor = getInstrumentation().addMonitor(Checkout.class.getName(), null, false);
        mainActivity = getActivity();

        payBtn = (Button) mainActivity.findViewById(R.id.payBtn);
        payBtnUserData = (Button) mainActivity.findViewById(R.id.payBtnUserData);
        payBtnFail = (Button) mainActivity.findViewById(R.id.payBtnFail);
        payBtnCustomImage = (Button) mainActivity.findViewById(R.id.payBtnCustomImage);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
