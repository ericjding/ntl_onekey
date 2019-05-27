package org.sil.ntl_onekey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import org.sil.ntl_onekey.BuildConfig;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    setTheme(R.style.AppTheme);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView textView0 = (TextView) findViewById(R.id.textView0);
    String apptitle = getResources().getString(R.string.apptitle);
    textView0.setText(Html.fromHtml(apptitle));

    Button button1 = (Button) findViewById(R.id.button1);
    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS));
      }
    });

    Button button2 = (Button) findViewById(R.id.button2);
    button2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        InputMethodManager imManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imManager.showInputMethodPicker();
      }
    });

    // Use setText rather than hardcoding in activity_main.xml so we can
    // use HTML tags.
    TextView textView2 = (TextView) findViewById(R.id.textView2);
    String aboutstring = getResources().getString(R.string.aboutntlonekey);
    aboutstring = aboutstring.replace("VNAME",BuildConfig.VERSION_NAME);
    textView2.setText(Html.fromHtml(aboutstring));
    textView2.setMovementMethod(LinkMovementMethod.getInstance());
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
