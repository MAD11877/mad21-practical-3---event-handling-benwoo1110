package sg.edu.np.mad.madpractical;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        activityRule.getScenario();
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("sg.edu.np.mad.madpractical", appContext.getPackageName());
    }

    @Test
    public void followClickTest() {
        // Context of the app under test.
        onView(withId(R.id.buttonFollow))
                .check((view, noViewFoundException) -> {
                    String followText = ((Button) view).getText().toString().toLowerCase();
                    assertEquals("follow", followText);
                })
                .perform(click())
                .check((view, noViewFoundException) -> {
                    String followText = ((Button) view).getText().toString().toLowerCase();
                    assertEquals("unfollow", followText);
                });
    }
}