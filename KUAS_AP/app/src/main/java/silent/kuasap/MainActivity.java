package silent.kuasap;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.alertdialogpro.AlertDialogPro;
import com.alertdialogpro.ProgressDialogPro;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import us.codecraft.xsoup.Xsoup;

import static android.view.Gravity.START;


public class MainActivity extends ActionBarActivity {
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0";
    CookieStore cookieStore = new BasicCookieStore();
    private String _loginUrl = "http://140.127.113.231/kuas/perchk.jsp";
    private String _usernameUrl = "http://140.127.113.231/kuas/f_head.jsp";
    private String _fncUrl = "http://140.127.113.231/kuas/fnc.jsp";
    private String _scoreUrl = "http://140.127.113.231/kuas/ag_pro/ag008.jsp";
    private String _courseUrl = "http://140.127.113.231/kuas/ag_pro/ag222.jsp";
    private String _fncid = "";
    private String Uid = "";
    private String Pwd = "";

    private String ymsScore = "";

    private DrawerArrowDrawable drawerArrowDrawable;
    private float offset;
    private boolean flipped;
    private ListView mDrawerList;
    private ListView mAboutList;

    public static final int LoginInit = -1;
    public static final int LoginSuccess = 2;
    public static final int LoginError = 1;

    Runnable ReadSemesterRunnable;

    private Spinner spinner;
    private ArrayList<String> SemesterList = new ArrayList<>();
    private ArrayList<String> SemesterValue = new ArrayList<>();
    private ArrayAdapter<String> listAdapter;

    // Login
    private EditText UserNameEditText;
    private EditText PasswordEditText;
    private Button SignInButton;
    private CheckBox RememberPass;
    Runnable LoginRunnable;
    AlertDialog LoadingDialog;

    // Score
    Runnable ReadScoreRunnable;
    private ArrayList<ScoreList> ScoreList = new ArrayList<>();
    private ArrayList<String> Score2List = new ArrayList<>();

    // Course
    Runnable ReadCourseRunnable;
    private ArrayList<ArrayList<CourseList>> CourseList = new ArrayList<>();
    boolean isNightClass = false;
    boolean isHolidayNightClass = false;
    boolean isHolidayClass = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initLogin();

        ReadSemesterRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (!CheckLoginState())
                        ReLogin();

                    ReadSemesterHandler.sendEmptyMessage(-1);
                    List<NameValuePair> params = new LinkedList<>();
                    params.add(new BasicNameValuePair("fncid", _fncid));
                    if (Calendar.getInstance().get(Calendar.MONTH) > 9 && Calendar.getInstance().get(Calendar.MONTH) < 2)
                    {
                        if (Calendar.getInstance().get(Calendar.MONTH) < 2)
                            params.add(new BasicNameValuePair("sysyear", Integer.toString(Calendar.getInstance().get(Calendar.YEAR)  - 1912)));
                        else
                            params.add(new BasicNameValuePair("sysyear", Integer.toString(Calendar.getInstance().get(Calendar.YEAR)  - 1911)));
                        params.add(new BasicNameValuePair("syssms", "1"));
                    }
                    else
                    {
                        params.add(new BasicNameValuePair("sysyear", Integer.toString(Calendar.getInstance().get(Calendar.YEAR)  - 1911)));
                        params.add(new BasicNameValuePair("syssms", "2"));
                    }
                    params.add(new BasicNameValuePair("std_id", ""));
                    params.add(new BasicNameValuePair("local_ip", ""));
                    params.add(new BasicNameValuePair("online", "okey"));
                    params.add(new BasicNameValuePair("loginid", Uid));
                    Document document = Jsoup.parse(post_url_contents(_fncUrl, params, cookieStore));
                    String ls_randnum = Xsoup.compile("//input[9]").evaluate(document).getElements().attr("value");
                    String _arg01 = Xsoup.compile("//input[1]").evaluate(document).getElements().attr("value");
                    String _arg02 = Xsoup.compile("//input[2]").evaluate(document).getElements().attr("value");

                    params.clear();
                    params.add(new BasicNameValuePair("fncid", _fncid));
                    params.add(new BasicNameValuePair("arg01", _arg01));
                    params.add(new BasicNameValuePair("arg02", _arg02));
                    params.add(new BasicNameValuePair("arg03", Uid));
                    params.add(new BasicNameValuePair("arg04", ""));
                    params.add(new BasicNameValuePair("arg05", ""));
                    params.add(new BasicNameValuePair("arg06", ""));
                    params.add(new BasicNameValuePair("uid", Uid));
                    params.add(new BasicNameValuePair("ls_randnum", ls_randnum));
                    if (_fncid.equals("AG008"))
                        document = Jsoup.parse(post_url_contents("http://140.127.113.231/kuas/system/sys001_00.jsp?spath=ag_pro/ag008.jsp?", params, cookieStore));
                    else if (_fncid.equals("AG222"))
                        document = Jsoup.parse(post_url_contents("http://140.127.113.231/kuas/system/sys001_00.jsp?spath=ag_pro/ag008.jsp?", params, cookieStore));
                    SemesterList = new ArrayList<>();
                    SemesterValue = new ArrayList<>();
                    ymsScore = "";
                    for (Element element : Xsoup.compile("//option").evaluate(document).getElements())
                    {
                        SemesterList.add(element.text());
                        SemesterValue.add(element.attr("value"));
                    }
                    ymsScore = Xsoup.compile("//option[@selected]").evaluate(document).getElements().attr("value");
                    ReadSemesterHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public Boolean CheckLoginState()
    {
        try {
            Document document = Jsoup.parse(get_url_contents(_usernameUrl, null, cookieStore));
            if (Xsoup.compile("/html/body/div[1]/div/div[3]/span[3]").evaluate(document).get() != null)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean ReLogin()
    {
        Log.d("KUAS AP", "ReLogin");
        cookieStore = new BasicCookieStore();
        List<NameValuePair> params = new LinkedList<>();
        params.add(new BasicNameValuePair("uid", Uid));
        params.add(new BasicNameValuePair("pwd", Pwd));
        post_url_contents(_loginUrl, params, cookieStore);
        return CheckLoginState();
    }

    public void initLogin(){
        setContentView(R.layout.login);

        UserNameEditText = (EditText) findViewById(R.id.Username);
        PasswordEditText = (EditText) findViewById(R.id.Password);
        SignInButton = (Button) findViewById(R.id.SignIn);
        RememberPass = (CheckBox) findViewById(R.id.RememberPass);

        LoadingDialog = new ProgressDialogPro(this, R.style.Theme_AlertDialogPro_Material);

        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(UserNameEditText.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(PasswordEditText.getWindowToken(), 0);

                new Thread(LoginRunnable).start();
            }
        });

        mDrawerList = (ListView)findViewById(R.id.drawerlistView);
        mAboutList = (ListView)findViewById(R.id.aboutlistView);
        final String[] aboutvalues = new String[]{ "關於我們"};

        ArrayAdapter<String> aboutadapter=new ArrayAdapter<String>(
                this,R.layout.aboutlistview_item, aboutvalues){
            private LayoutInflater mInflater = LayoutInflater.from(MainActivity.this);

            class ViewHolder {
                public TextView textView;
                public ImageView imageView;
            }

            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.aboutlistview_item, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.textView);
                    holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder)convertView.getTag();
                }
                holder.textView.setText(aboutvalues[position]);
                holder.imageView.setBackgroundResource(R.drawable.ic_thumb_up_black_48dp);
                return convertView;
            }
        };
        mAboutList.setAdapter(aboutadapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }
            }
        });
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ImageView imageView = (ImageView) findViewById(R.id.drawer_indicator);
        final Resources resources = getResources();
        drawerArrowDrawable = new DrawerArrowDrawable(resources, true);
        drawerArrowDrawable.setStrokeColor(Color.WHITE);
        imageView.setImageDrawable(drawerArrowDrawable);
        drawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                offset = slideOffset;
                // Sometimes slideOffset ends up so close to but not quite 1 or 0.
                if (slideOffset >= .995) {
                    flipped = true;
                    drawerArrowDrawable.setFlip(flipped);
                } else if (slideOffset <= .005) {
                    flipped = false;
                    drawerArrowDrawable.setFlip(flipped);
                }
                drawerArrowDrawable.setParameter(offset);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(START)) {
                    drawer.closeDrawer(START);
                } else {
                    drawer.openDrawer(START);
                }
            }
        });

        restorePrefs();

        LoginRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    cookieStore = new BasicCookieStore();
                    LoginHandler.sendEmptyMessage(LoginInit);
                    List<NameValuePair> params = new LinkedList<>();
                    params.add(new BasicNameValuePair("uid", UserNameEditText.getText().toString()));
                    params.add(new BasicNameValuePair("pwd", PasswordEditText.getText().toString()));
                    post_url_contents(_loginUrl, params, cookieStore);
                    if (CheckLoginState())
                    {
                        Uid = UserNameEditText.getText().toString();
                        Pwd =  PasswordEditText.getText().toString();
                        savePrefs();
                        LoginHandler.sendEmptyMessage(LoginSuccess);
                    }
                    else
                    {
                        LoginHandler.sendEmptyMessage(LoginError);
                        System.out.println("Error");
                    }
                } catch (Exception e) {
                    LoginHandler.sendEmptyMessage(LoginError);
                    e.printStackTrace();
                }
            }
        };
    }

    public void initLogout(){
        setContentView(R.layout.logout);

        mDrawerList = (ListView)findViewById(R.id.drawerlistView);
        mAboutList = (ListView)findViewById(R.id.aboutlistView);
        final String[] aboutvalues = new String[]{ "關於我們"};
        final String[] values = new String[]{ "學期課表", "學期成績", "缺曠系統", "校車系統", "校園資訊" };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.aboutlistview_item, values){
            private LayoutInflater mInflater = LayoutInflater.from(MainActivity.this);

            class ViewHolder {
                public TextView textView;
                public ImageView imageView;
            }

            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.aboutlistview_item, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.textView);
                    holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder)convertView.getTag();
                }
                holder.textView.setText(values[position]);
                return convertView;
            }
        };
        ArrayAdapter<String> aboutadapter=new ArrayAdapter<String>(
                this,R.layout.aboutlistview_item, aboutvalues){
            private LayoutInflater mInflater = LayoutInflater.from(MainActivity.this);

            class ViewHolder {
                public TextView textView;
                public ImageView imageView;
            }

            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.aboutlistview_item, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.textView);
                    holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder)convertView.getTag();
                }
                holder.textView.setText(aboutvalues[position]);
                holder.imageView.setBackgroundResource(R.drawable.ic_thumb_up_black_48dp);
                return convertView;
            }
        };
        mAboutList.setAdapter(aboutadapter);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse();
                        break;
                    case 1:
                        initScore();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }
            }
        });
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ImageView imageView = (ImageView) findViewById(R.id.drawer_indicator);
        final Resources resources = getResources();
        drawerArrowDrawable = new DrawerArrowDrawable(resources, true);
        drawerArrowDrawable.setStrokeColor(Color.WHITE);
        imageView.setImageDrawable(drawerArrowDrawable);
        drawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                offset = slideOffset;
                // Sometimes slideOffset ends up so close to but not quite 1 or 0.
                if (slideOffset >= .995) {
                    flipped = true;
                    drawerArrowDrawable.setFlip(flipped);
                } else if (slideOffset <= .005) {
                    flipped = false;
                    drawerArrowDrawable.setFlip(flipped);
                }
                drawerArrowDrawable.setParameter(offset);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(START)) {
                    drawer.closeDrawer(START);
                } else {
                    drawer.openDrawer(START);
                }
            }
        });

        Button Logout = (Button) findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cookieStore = new BasicCookieStore();
                initLogin();
            }
        });

    }

    public void initCourse(){
        setContentView(R.layout.course);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!ymsScore.equals(SemesterValue.get(position)))
                {
                    ymsScore = SemesterValue.get(position);
                    ReadCourseHandler.sendEmptyMessage(-1);
                    new Thread(ReadCourseRunnable).start();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ImageView Logout = (ImageView) findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initLogout();
            }
        });
        mDrawerList = (ListView)findViewById(R.id.drawerlistView);
        mAboutList = (ListView)findViewById(R.id.aboutlistView);
        final String[] aboutvalues = new String[]{ "關於我們"};
        final String[] values = new String[]{ "學期成績", "缺曠系統", "校車系統", "校園資訊" };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.aboutlistview_item, values){
            private LayoutInflater mInflater = LayoutInflater.from(MainActivity.this);

            class ViewHolder {
                public TextView textView;
                public ImageView imageView;
            }

            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.aboutlistview_item, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.textView);
                    holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder)convertView.getTag();
                }
                holder.textView.setText(values[position]);
                return convertView;
            }
        };
        ArrayAdapter<String> aboutadapter=new ArrayAdapter<String>(
                this,R.layout.aboutlistview_item, aboutvalues){
            private LayoutInflater mInflater = LayoutInflater.from(MainActivity.this);

            class ViewHolder {
                public TextView textView;
                public ImageView imageView;
            }

            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.aboutlistview_item, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.textView);
                    holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder)convertView.getTag();
                }
                holder.textView.setText(aboutvalues[position]);
                holder.imageView.setBackgroundResource(R.drawable.ic_thumb_up_black_48dp);
                return convertView;
            }
        };
        mAboutList.setAdapter(aboutadapter);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initScore();
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }
            }
        });
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ImageView imageView = (ImageView) findViewById(R.id.drawer_indicator);
        final Resources resources = getResources();
        drawerArrowDrawable = new DrawerArrowDrawable(resources, true);
        drawerArrowDrawable.setStrokeColor(Color.WHITE);
        imageView.setImageDrawable(drawerArrowDrawable);
        drawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                offset = slideOffset;
                // Sometimes slideOffset ends up so close to but not quite 1 or 0.
                if (slideOffset >= .995) {
                    flipped = true;
                    drawerArrowDrawable.setFlip(flipped);
                } else if (slideOffset <= .005) {
                    flipped = false;
                    drawerArrowDrawable.setFlip(flipped);
                }
                drawerArrowDrawable.setParameter(offset);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(START)) {
                    drawer.closeDrawer(START);
                } else {
                    drawer.openDrawer(START);
                }
            }
        });

        ReadCourseRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (!CheckLoginState())
                        ReLogin();

                    List<NameValuePair> params = new LinkedList<>();
                    params.add(new BasicNameValuePair("yms", ymsScore));
                    params.add(new BasicNameValuePair("arg01", ymsScore.split(",")[0]));
                    params.add(new BasicNameValuePair("arg02", ymsScore.split(",")[1]));
                    params.add(new BasicNameValuePair("spath", "ag_pro/ag222.jsp?"));
                    Document document = Jsoup.parse(post_url_contents(_courseUrl, params, cookieStore));

                    isHolidayClass = false;
                    isHolidayNightClass = false;
                    isNightClass = false;
                    CourseList = new ArrayList<>();
                    for (int i = 2; i <= Xsoup.compile("/html/body/table/tbody/tr").evaluate(document).list().size(); i++)
                    {
                        ArrayList<CourseList> CourseList2 = new ArrayList<>();
                        String getData = Xsoup.compile("/html/body/table/tbody/tr[" + i + "]").evaluate(document).getElements().text().replace("  ","x");
                        for (int j = 2; j <= 8 ; j++)
                        {
                           if (getData.split("x")[j].split(" ").length >=2)
                           {
                               if (j >= 7)
                               {
                                   isHolidayClass = true;
                                   if (i >= 12)
                                       isHolidayNightClass = true;
                               }
                               else
                                   if (i >= 12)
                                       isNightClass = true;
                               if (getData.split("x")[j].split(" ").length ==2)
                                   CourseList2.add(new CourseList(getData.split("x")[j].split(" ")[0], getData.split("x")[j].split(" ")[1], "", getData.split("x")[1]));
                               else
                                   CourseList2.add(new CourseList(getData.split("x")[j].split(" ")[0], getData.split("x")[j].split(" ")[1], getData.split("x")[j].split(" ")[2], getData.split("x")[1]));
                           }
                           else
                               CourseList2.add(new CourseList("", "", "", ""));
                        }
                        CourseList.add(CourseList2);
                    }
                    ReadCourseHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        _fncid = "AG222";
        new Thread(ReadSemesterRunnable).start();
    }

    public void initScore(){
        setContentView(R.layout.score);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!ymsScore.equals(SemesterValue.get(position)))
                {
                    ymsScore = SemesterValue.get(position);
                    ReadScoreHandler.sendEmptyMessage(-1);
                    new Thread(ReadScoreRunnable).start();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ImageView Logout = (ImageView) findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initLogout();
            }
        });
        mDrawerList = (ListView)findViewById(R.id.drawerlistView);
        mAboutList = (ListView)findViewById(R.id.aboutlistView);
        final String[] aboutvalues = new String[]{ "關於我們"};
        final String[] values = new String[]{ "學期課表", "缺曠系統", "校車系統", "校園資訊" };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.aboutlistview_item, values){
            private LayoutInflater mInflater = LayoutInflater.from(MainActivity.this);

            class ViewHolder {
                public TextView textView;
                public ImageView imageView;
            }

            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.aboutlistview_item, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.textView);
                    holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder)convertView.getTag();
                }
                holder.textView.setText(values[position]);
                return convertView;
            }
        };
        ArrayAdapter<String> aboutadapter=new ArrayAdapter<String>(
                this,R.layout.aboutlistview_item, aboutvalues){
            private LayoutInflater mInflater = LayoutInflater.from(MainActivity.this);

            class ViewHolder {
                public TextView textView;
                public ImageView imageView;
            }

            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.aboutlistview_item, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.textView);
                    holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder)convertView.getTag();
                }
                holder.textView.setText(aboutvalues[position]);
                holder.imageView.setBackgroundResource(R.drawable.ic_thumb_up_black_48dp);
                return convertView;
            }
        };
        mAboutList.setAdapter(aboutadapter);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse();
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }
            }
        });
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ImageView imageView = (ImageView) findViewById(R.id.drawer_indicator);
        final Resources resources = getResources();
        drawerArrowDrawable = new DrawerArrowDrawable(resources, true);
        drawerArrowDrawable.setStrokeColor(Color.WHITE);
        imageView.setImageDrawable(drawerArrowDrawable);
        drawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                offset = slideOffset;
                // Sometimes slideOffset ends up so close to but not quite 1 or 0.
                if (slideOffset >= .995) {
                    flipped = true;
                    drawerArrowDrawable.setFlip(flipped);
                } else if (slideOffset <= .005) {
                    flipped = false;
                    drawerArrowDrawable.setFlip(flipped);
                }
                drawerArrowDrawable.setParameter(offset);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(START)) {
                    drawer.closeDrawer(START);
                } else {
                    drawer.openDrawer(START);
                }
            }
        });

        ReadScoreRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (!CheckLoginState())
                        ReLogin();
                    List<NameValuePair> params = new LinkedList<>();
                    params.add(new BasicNameValuePair("yms", ymsScore));
                    params.add(new BasicNameValuePair("arg01", ymsScore.split(",")[0]));
                    params.add(new BasicNameValuePair("arg02", ymsScore.split(",")[1]));
                    params.add(new BasicNameValuePair("spath", "ag_pro/ag008.jsp?"));
                    Document document = Jsoup.parse(post_url_contents(_scoreUrl, params, cookieStore));
                    ScoreList = new ArrayList<>();
                    Score2List = new ArrayList<>();
                    for (int j = 2; j <= Xsoup.compile("/html/body/form/table/tbody/tr").evaluate(document).list().size(); j++)
                        ScoreList.add(new ScoreList(Xsoup.compile("/html/body/form/table/tbody/tr[" + j + "]/td[2]").evaluate(document).getElements().text().trim(),
                                Xsoup.compile("/html/body/form/table/tbody/tr[" + j + "]/td[7]").evaluate(document).getElements().text().trim(),
                                Xsoup.compile("/html/body/form/table/tbody/tr[" + j + "]/td[8]").evaluate(document).getElements().text().trim()));

                    for (String xxx : Xsoup.compile("/html/body/form/table/caption/div/text()").evaluate(document).getElements().text().replace("　　　　", " ").split(" "))
                        Score2List.add(xxx);
                    ReadScoreHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        _fncid = "AG008";
        new Thread(ReadSemesterRunnable).start();
    }

    private Handler ReadScoreHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what)
            {
                case -1:
                    LoadingDialog.setMessage("Loading...");
                    ProgressDialogPro progressDialog = (ProgressDialogPro) LoadingDialog;
                    progressDialog.setProgressStyle(ProgressDialogPro.STYLE_SPINNER);
                    progressDialog.setIndeterminate(true);
                    LoadingDialog.setCancelable(false);
                    LoadingDialog.setCanceledOnTouchOutside(false);
                    LoadingDialog.show();
                    break;
                case 1:
                    addScore();
                    LoadingDialog.dismiss();
                    break;
            }
        };
    };

    private Handler ReadCourseHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what)
            {
                case -1:
                    LoadingDialog.setMessage("Loading...");
                    ProgressDialogPro progressDialog = (ProgressDialogPro) LoadingDialog;
                    progressDialog.setProgressStyle(ProgressDialogPro.STYLE_SPINNER);
                    progressDialog.setIndeterminate(true);
                    LoadingDialog.setCancelable(false);
                    LoadingDialog.setCanceledOnTouchOutside(false);
                    LoadingDialog.show();
                    break;
                case 1:
                    addCourse();
                    LoadingDialog.dismiss();
                    break;
            }
        };
    };

    private Handler ReadSemesterHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what)
            {
                case -1:
                    LoadingDialog.setMessage("Loading...");
                    ProgressDialogPro progressDialog = (ProgressDialogPro) LoadingDialog;
                    progressDialog.setProgressStyle(ProgressDialogPro.STYLE_SPINNER);
                    progressDialog.setIndeterminate(true);
                    LoadingDialog.setCancelable(false);
                    LoadingDialog.setCanceledOnTouchOutside(false);
                    LoadingDialog.show();
                    break;
                case 1:
                    listAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.dropdown_item, SemesterList);
                    spinner.setAdapter(listAdapter);
                    for (int i = 0; i < SemesterValue.size(); i++)
                        if (SemesterValue.get(i).equals(ymsScore))
                        {
                            spinner.setSelection(i);
                            break;
                        }
                    if (_fncid.equals("AG008"))
                        new Thread(ReadScoreRunnable).start();
                    else if (_fncid.equals("AG222"))
                        new Thread(ReadCourseRunnable).start();
                    break;
            }
        };
    };

    private Handler LoginHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what)
            {
                case -1:
                    LoadingDialog.setMessage("Loading...");
                    ProgressDialogPro progressDialog = (ProgressDialogPro) LoadingDialog;
                    progressDialog.setProgressStyle(ProgressDialogPro.STYLE_SPINNER);
                    progressDialog.setIndeterminate(true);
                    LoadingDialog.setCancelable(false);
                    LoadingDialog.setCanceledOnTouchOutside(false);
                    LoadingDialog.show();
                    break;
                case 1:
                    LoadingDialog.dismiss();
                    AlertDialogPro.Builder builder = new AlertDialogPro.Builder(MainActivity.this);
                    builder.setTitle("Error").
                            setMessage("帳號或密碼輸入錯誤 !").
                            //setIcon(R.drawable.ic_error_red_48dp).
                            setPositiveButton("確定", null).show();
                    SignInButton.setEnabled(true);
                    UserNameEditText.setEnabled(true);
                    PasswordEditText.setEnabled(true);
                    break;
                case 2:
                    LoadingDialog.dismiss();
                    SignInButton.setEnabled(true);
                    UserNameEditText.setEnabled(true);
                    PasswordEditText.setEnabled(true);
                    initLogout();
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        };
    };

    public void addCourse() {
        TableLayout table = (TableLayout) findViewById(R.id.tablelayout);
        table.setStretchAllColumns(true);
        table.removeAllViews();
        TextView textView = (TextView) findViewById(R.id.textView);
        if (!isHolidayClass)
            textView.setVisibility(View.GONE);
        else
            textView.setVisibility(View.VISIBLE);

        if (CourseList.size() == 0)
        {
            TableRow tablerow = new TableRow(MainActivity.this);
            final TextView testview = new TextView(MainActivity.this);
            testview.setTextSize(17);
            testview.setGravity(Gravity.CENTER);
            testview.setText("目前無學生個人選課資料");
            testview.setBackgroundResource(R.drawable.tablelayout_oneitem);
            tablerow.addView(testview,new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            table.addView(tablerow);
            return;
        }

        TableRow tablerowx = new TableRow(MainActivity.this);
        String[] titles = {};

        int x, y;
        if (getResources().getConfiguration().orientation == 2) //橫向
        {
            textView.setVisibility(View.GONE);
            if (isHolidayClass)
            {
                titles = new String[]{"　", "一", "二", "三", "四", "五", "六", "日"};
                if (isNightClass || isHolidayNightClass)
                    y = CourseList.size();
                else
                    y = 10;
                x = 8;
            }
            else
            {
                titles = new String[]{"　", "一", "二", "三", "四", "五"};
                if (isNightClass)
                    y = CourseList.size();
                else
                    y = 10;
                x = 6;
            }
        }
        else //垂直
        {
            titles = new String[]{"　", "一", "二", "三", "四", "五"};
            x = 6;
            if (isNightClass)
                y = CourseList.size();
            else
                y = 10;
        }

        for (int i = 0; i < titles.length; i++)
        {
            TextView title = new TextView(MainActivity.this);
            title.setText(titles[i]);
            title.setTextColor(getResources().getColor(R.color.blue));
            title.setTextSize(18);
            title.setGravity(Gravity.CENTER);
            if (i == 0)
                title.setBackgroundResource(R.drawable.tablelayout_top_left);
            else if (i == titles.length-1)
                title.setBackgroundResource(R.drawable.tablelayout_top_right);
            else
                title.setBackgroundResource(R.drawable.tablelayout_top_center);
            tablerowx.addView(title);
        }
        table.addView(tablerowx);

        String[] titles2 = {"M", "第1節", "第2節", "第3節", "第4節", "A", "第5節", "第6節", "第7節", "第8節", "B", "第11節", "第12節", "第13節", "第14節"};
        for (int i = 0; i < y; i++) {
            TableRow tablerow = new TableRow(MainActivity.this);
            for (int j = 0; j < x; j++) {
                final TextView testview = new TextView(MainActivity.this);
                testview.setTextSize(17);

                if (j == 0)
                {
                    testview.setTextColor(getResources().getColor(R.color.blue));
                    testview.setTextSize(18);
                    testview.setText(titles2[i]);
                }
                else
                {
                    if (CourseList.get(i).get(j - 1).ID.length() > 0)
                        testview.setText(CourseList.get(i).get(j - 1).ID.substring(0,2));
                    else
                        testview.setText(CourseList.get(i).get(j - 1).ID);
                }

                final int yy = i;
                final int xx = j;
                if (j != 0 && !CourseList.get(i).get(j - 1).ID.equals(""))
                    testview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialogPro.Builder builder = new AlertDialogPro.Builder(MainActivity.this);
                            builder.
                                    setMessage("課程名稱：" + CourseList.get(yy).get(xx - 1).ID
                                            + "\n授課老師：" +  CourseList.get(yy).get(xx - 1).Teacher
                                            + "\n教室位置：" + CourseList.get(yy).get(xx - 1).Place
                                            + "\n上課時間：" + CourseList.get(yy).get(xx - 1).Time).
                                            setPositiveButton("確定", null).show();
                        }
                    });

                testview.setGravity(Gravity.CENTER);
                if (j == 0)
                {
                    if (i == y-1)
                        testview.setBackgroundResource(R.drawable.tablelayout_bottom_left);
                    else
                        testview.setBackgroundResource(R.drawable.tablelayout_normal_left);
                }
                else if (j == x-1)
                {
                    if (i == y-1)
                        testview.setBackgroundResource(R.drawable.tablelayout_bottom_right);
                    else
                        testview.setBackgroundResource(R.drawable.tablelayout_normal_right);
                }
                else
                {
                    if (i == y-1)
                        testview.setBackgroundResource(R.drawable.tablelayout_bottom_center);
                    else
                        testview.setBackgroundResource(R.drawable.tablelayout_normal_center);
                }
                tablerow.addView(testview,new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            }
            table.addView(tablerow);
        }
    }

    public void addScore() {
        TableLayout table = (TableLayout) findViewById(R.id.tablelayout);
        TableLayout table2 = (TableLayout) findViewById(R.id.tablelayout2);
        table.setStretchAllColumns(true);
        table.removeAllViews();
        table2.removeAllViews();

        if (ScoreList.size() == 0)
        {
            TableRow tablerow = new TableRow(MainActivity.this);
            final TextView testview = new TextView(MainActivity.this);
            testview.setTextSize(14);
            testview.setGravity(Gravity.CENTER);
            testview.setText("目前無學生個人成績資料");
            testview.setBackgroundResource(R.drawable.tablelayout_oneitem);
            tablerow.addView(testview,new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            table.addView(tablerow);
            return;
        }

        TableRow tablerowx = new TableRow(MainActivity.this);
        String[] titles = {"科目", "期中成績","學期成績"};
        for (int i = 0; i < 3; i++)
        {
            TextView title = new TextView(MainActivity.this);
            title.setText(titles[i]);
            title.setTextColor(getResources().getColor(R.color.blue));
            title.setTextSize(15);
            title.setGravity(Gravity.CENTER);
            switch (i)
            {
                case 0:
                    title.setBackgroundResource(R.drawable.tablelayout_top_left);
                    break;
                case 1:
                    title.setBackgroundResource(R.drawable.tablelayout_top_center);
                    break;
                case 2:
                    title.setBackgroundResource(R.drawable.tablelayout_top_right);
                    break;
            }
            tablerowx.addView(title);
        }

        table.addView(tablerowx);

        for (int i = 0; i < ScoreList.size(); i++) {
            TableRow tablerow = new TableRow(MainActivity.this);
            for (int j = 0; j < 3; j++) {
                final TextView testview = new TextView(MainActivity.this);
                testview.setTextSize(14);

                if (j == 0)
                    testview.setText(ScoreList.get(i).ID);
                else if (j == 1)
                    testview.setText(ScoreList.get(i).Midterm);
                else if (j == 2)
                    testview.setText(ScoreList.get(i).Final);

                testview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(testview.getText().toString());
                    }
                });

                testview.setGravity(Gravity.CENTER);
                switch (j)
                {
                    case 0:
                        if (i == ScoreList.size()-1)
                            testview.setBackgroundResource(R.drawable.tablelayout_bottom_left);
                        else
                            testview.setBackgroundResource(R.drawable.tablelayout_normal_left);
                        break;
                    case 1:
                        if (i == ScoreList.size()-1)
                            testview.setBackgroundResource(R.drawable.tablelayout_bottom_center);
                        else
                            testview.setBackgroundResource(R.drawable.tablelayout_normal_center);
                        break;
                    case 2:
                        if (i == ScoreList.size()-1)
                            testview.setBackgroundResource(R.drawable.tablelayout_bottom_right);
                        else
                            testview.setBackgroundResource(R.drawable.tablelayout_normal_right);
                        break;
                }
                tablerow.addView(testview,new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            }
            table.addView(tablerow);
        }

        for (int i = 0; i < Score2List.size(); i++)
        {
            TableRow tablerow = new TableRow(MainActivity.this);
            final TextView testview = new TextView(MainActivity.this);
            testview.setTextSize(14);
            testview.setGravity(Gravity.CENTER);
            testview.setText(Score2List.get(i));
            if (i == 0)
                testview.setBackgroundResource(R.drawable.tablelayout_oneitem_top);
            else if (i == Score2List.size()-1)
                testview.setBackgroundResource(R.drawable.tablelayout_oneitem_bottom);
            else
                testview.setBackgroundResource(R.drawable.tablelayout_oneitem_normal);
            tablerow.addView(testview,new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            table2.addView(tablerow);
        }

    }

    String get_url_contents( String url , List<NameValuePair> params , CookieStore cookieStore ) {
        try {
            HttpClient client = new DefaultHttpClient();
            client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, USER_AGENT);
            HttpResponse response = null;
            if( cookieStore == null )
                response = client.execute( new HttpGet( params == null || params.size() == 0 ? url : url + "?" + URLEncodedUtils.format(params, "utf-8") ) );
            else {
                HttpContext mHttpContext = new BasicHttpContext();
                mHttpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
                response = client.execute( new HttpGet( params == null || params.size() == 0 ? url : url + "?" + URLEncodedUtils.format(params, "utf-8") ) , mHttpContext );
            }
            HttpEntity result = response.getEntity();
            if( result != null ) {
                InputStream mInputStream = result.getContent();
                String out = getStringFromInputStream(mInputStream);
                mInputStream.close();
                return out;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    String post_url_contents( String url, List<NameValuePair> params , CookieStore cookieStore ) {
        try {
            HttpClient client = new DefaultHttpClient();
            client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, USER_AGENT);
            HttpPost mHttpPost = new HttpPost(url);
            HttpResponse response = null;
            if( params != null && params.size() > 0 )
                mHttpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            if( cookieStore == null )
                response = client.execute( mHttpPost );
            else {
                HttpContext mHttpContext = new BasicHttpContext();
                mHttpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
                response = client.execute( mHttpPost , mHttpContext );
            }
            HttpEntity result = response.getEntity();
            if( result != null ) {
                InputStream mInputStream = result.getContent();
                String out = getStringFromInputStream(mInputStream);
                mInputStream.close();
                return out;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    String getStringFromInputStream(InputStream in) {
        byte []data = new byte[1024];
        int length;
        if( in == null )
            return null;
        ByteArrayOutputStream mByteArrayOutputStream = new ByteArrayOutputStream();
        try {
            while( (length = in.read(data)) != -1 )
                mByteArrayOutputStream.write(data, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(mByteArrayOutputStream.toByteArray());
    }


    private void restorePrefs() {
        SharedPreferences setting = getSharedPreferences("KUAS AP", 0);
        String username = setting.getString("User", "");
        String password = setting.getString("Pwd", "");
        Boolean remember = setting.getBoolean("Remember", true);
        UserNameEditText.setText(username);
        PasswordEditText.setText(password);
        RememberPass.setChecked(remember);
    }
    private void savePrefs() {
        SharedPreferences setting = getSharedPreferences("KUAS AP", 0);
        setting.edit().putString("User", UserNameEditText.getText().toString()).apply();
        if (RememberPass.isChecked())
            setting.edit().putString("Pwd", PasswordEditText.getText().toString()).apply();
        else
            setting.edit().putString("Pwd", "").apply();
        setting.edit().putBoolean("Remember", RememberPass.isChecked()).apply();

    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) { }
        else { }
        if (_fncid.equals("AG222") && !LoadingDialog.isShowing())
            addCourse();
    }
}
