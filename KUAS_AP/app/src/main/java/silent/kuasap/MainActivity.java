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
import android.widget.RelativeLayout;
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
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

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
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0";
    String BusJs = "function baseEncryption(e) {function h(b, a) { var d, c, e, f, g; e = b & 2147483648; f = a & 2147483648; d = b & 1073741824; c = a & 1073741824; g = (b & 1073741823) + (a & 1073741823); return d & c ? g ^ 2147483648 ^ e ^ f : d | c ? g & 1073741824 ? g ^ 3221225472 ^ e ^ f : g ^ 1073741824 ^ e ^ f : g ^ e ^ f } function g(b, a, d, c, e, f, g) { b = h(b, h(h(a & d | ~a & c, e), g)); return h(b << f | b >>> 32 - f, a) } function i(b, a, d, c, e, f, g) { b = h(b, h(h(a & c | d & ~c, e), g)); return h(b << f | b >>> 32 - f, a) } function j(b, a, c, d, e, f, g) { b = h(b, h(h(a ^ c ^ d, e), g)); return h(b << f | b >>> 32 - f, a) } function k(b, a, c, d, e, f, g) {b = h(b, h(h(c ^(a | ~d), e), g)); return h(b << f | b >>> 32 - f, a)} function l(b) { var a = \"\", c = \"\", d; for (d = 0; 3 >= d; d++) c = b >>> 8 * d & 255, c = \"0\" + c.toString(16), a += c.substr(c.length - 2, 2); return a } var f = [], m, n, o, p, b, a, d, c, f = function (b) { var a, c = b.length; a = c + 8; for (var d = 16 * ((a - a % 64) / 64 + 1), e = Array(d - 1), f = 0, g = 0; g < c; ) a = (g - g % 4) / 4, f = 8 * (g % 4), e[a] |= b.charCodeAt(g) << f, g++; a = (g - g % 4) / 4; e[a] |= 128 << 8 * (g % 4); e[d - 2] = c << 3; e[d - 1] = c >>> 29; return e } (e); b = 1732584193; a = 4023233417; d = 2562383102; c = 271733878; for (e = 0; e < f.length; e += 16) m = b, n = a, o = d, p = c, b = g(b, a, d, c, f[e +0], 7, 3614090360), c = g(c, b, a, d, f[e + 1], 12, 3905402710), d = g(d, c, b, a, f[e + 2], 17, 606105819), a = g(a, d, c, b, f[e + 3], 22, 3250441966), b = g(b, a, d, c, f[e + 4], 7, 4118548399), c = g(c, b, a, d, f[e + 5], 12, 1200080426), d = g(d, c, b, a, f[e + 6], 17, 2821735955), a = g(a, d, c, b, f[e + 7], 22, 4249261313), b = g(b, a, d, c, f[e + 8], 7, 1770035416), c = g(c, b, a, d, f[e + 9], 12, 2336552879), d = g(d, c, b, a, f[e + 10], 17, 4294925233), a = g(a, d, c, b, f[e + 11], 22, 2304563134), b = g(b, a, d, c, f[e + 12], 7, 1804603682), c = g(c, b, a, d, f[e + 13], 12, 4254626195), d = g(d, c, b, a, f[e + 14], 17, 2792965006), a = g(a, d,c, b, f[e + 15], 22, 1236535329), b = i(b, a, d, c, f[e + 1], 5, 4129170786), c = i(c, b, a, d, f[e + 6], 9, 3225465664), d = i(d, c, b, a, f[e + 11], 14, 643717713), a = i(a, d, c, b, f[e + 0], 20, 3921069994), b = i(b, a, d, c, f[e + 5], 5, 3593408605), c = i(c, b, a, d, f[e + 10], 9, 38016083), d = i(d, c, b, a, f[e + 15], 14, 3634488961), a = i(a, d, c, b, f[e + 4], 20, 3889429448), b = i(b, a, d, c, f[e + 9], 5, 568446438), c = i(c, b, a, d, f[e + 14], 9, 3275163606), d = i(d, c, b, a, f[e + 3], 14, 4107603335), a = i(a, d, c, b, f[e + 8], 20, 1163531501), b = i(b, a, d, c, f[e + 13], 5, 2850285829), c = i(c, b, a, d, f[e + 2], 9, 4243563512), d = i(d,c, b, a, f[e + 7], 14, 1735328473), a = i(a, d, c, b, f[e + 12], 20, 2368359562), b = j(b, a, d, c, f[e + 5], 4, 4294588738), c = j(c, b, a, d, f[e + 8], 11, 2272392833), d = j(d, c, b, a, f[e + 11], 16, 1839030562), a = j(a, d, c, b, f[e + 14], 23, 4259657740), b = j(b, a, d, c, f[e + 1], 4, 2763975236), c = j(c, b, a, d, f[e + 4], 11, 1272893353), d = j(d, c, b, a, f[e + 7], 16, 4139469664), a = j(a, d, c, b, f[e + 10], 23, 3200236656), b = j(b, a, d, c, f[e + 13], 4, 681279174), c = j(c, b, a, d, f[e + 0], 11, 3936430074), d = j(d, c, b, a, f[e + 3], 16, 3572445317), a = j(a, d, c, b, f[e + 6], 23, 76029189), b = j(b, a, d, c, f[e + 9], 4, 3654602809),c = j(c, b, a, d, f[e + 12], 11, 3873151461), d = j(d, c, b, a, f[e + 15], 16, 530742520), a = j(a, d, c, b, f[e + 2], 23, 3299628645), b = k(b, a, d, c, f[e + 0], 6, 4096336452), c = k(c, b, a, d, f[e + 7], 10, 1126891415), d = k(d, c, b, a, f[e + 14], 15, 2878612391), a = k(a, d, c, b, f[e + 5], 21, 4237533241), b = k(b, a, d, c, f[e + 12], 6, 1700485571), c = k(c, b, a, d, f[e + 3], 10, 2399980690), d = k(d, c, b, a, f[e + 10], 15, 4293915773), a = k(a, d, c, b, f[e + 1], 21, 2240044497), b = k(b, a, d, c, f[e + 8], 6, 1873313359), c = k(c, b, a, d, f[e + 15], 10, 4264355552), d = k(d, c, b, a, f[e + 6], 15, 2734768916), a = k(a, d, c, b, f[e + 13], 21,1309151649), b = k(b, a, d, c, f[e + 4], 6, 4149444226), c = k(c, b, a, d, f[e + 11], 10, 3174756917), d = k(d, c, b, a, f[e + 2], 15, 718787259), a = k(a, d, c, b, f[e + 9], 21, 3951481745), b = h(b, m), a = h(a, n), d = h(d, o), c = h(c, p); return (l(b) + l(a) + l(d) + l(c)).toLowerCase()}loginEncryption = function (e, h) {var g = Math.floor(1163531501 * Math.random()) + 15441, i = Math.floor(1163531502 * Math.random()) + 0, j = Math.floor(1163531502 * Math.random()) + 0, k = Math.floor(1163531502 * Math.random()) + 0, g = baseEncryption(\"J\" + g), i = baseEncryption(\"E\" + i), j = baseEncryption(\"R\" + j), k = baseEncryption(\"Y\" + k), e = baseEncryption(e + encA1(g)), h = baseEncryption(e + h + \"JERRY\" + encA1(i)), l = baseEncryption(e + h + \"KUAS\" + encA1(j)), l = baseEncryption(l + e + encA1(\"ITALAB\") + encA1(k)), l = baseEncryption(l + h + \"MIS\" + k); return '{ a:\"' + l + '\",b:\"' +g + '\",c:\"' + i + '\",d:\"' + j + '\",e:\"' + k + '\",f:\"' + h + '\" }'}; function encA2(e) { return baseEncryption(e) };";
    CookieStore cookieStore = new BasicCookieStore();
    private String _loginUrl = "http://140.127.113.231/kuas/perchk.jsp";
    private String _usernameUrl = "http://140.127.113.231/kuas/f_head.jsp";
    private String _fncUrl = "http://140.127.113.231/kuas/fnc.jsp";
    private String _scoreUrl = "http://140.127.113.231/kuas/ag_pro/ag008.jsp";
    private String _courseUrl = "http://140.127.113.231/kuas/ag_pro/ag222.jsp";
    private String _leaveSearchUrl = "http://140.127.113.231/kuas/ak_pro/ak002_01.jsp";
    private String _busLoginUrl = "http://bus.kuas.edu.tw/API/Users/login";
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

    private TextView SelectTextView;
    private ArrayList<String> SemesterList = new ArrayList<>();
    private ArrayList<String> SemesterValue = new ArrayList<>();

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

    // Leave
    Runnable ReadLeaveRunnable;
    ArrayList<LeaveList> LeaveList = new ArrayList<>();

    // Bus
    Runnable BusLoginRunnable;
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
                        document = Jsoup.parse(post_url_contents("http://140.127.113.231/kuas/system/sys001_00.jsp?spath=ag_pro/ag222.jsp?", params, cookieStore));
                    else if (_fncid.equals("AK002"))
                        document = Jsoup.parse(post_url_contents("http://140.127.113.231/kuas/system/sys001_00.jsp?spath=ak_pro/ak002_01.jsp?", params, cookieStore));
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
        System.out.println("ReLogin");
        cookieStore = new BasicCookieStore();
        List<NameValuePair> params = new LinkedList<>();
        params.add(new BasicNameValuePair("uid", Uid));
        params.add(new BasicNameValuePair("pwd", Pwd));
        post_url_contents(_loginUrl, params, cookieStore);
        return CheckLoginState();
    }

    public void initLogin(){
        setContentView(R.layout.login);

        _fncid = "";
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
        final String[] aboutvalues = new String[]{ "關於我們" };
        final String[] values = new String[]{ "校園資訊" };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.menulistview_item, values){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                this,R.layout.menulistview_item, aboutvalues){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                        initEvent1(false);
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
        _fncid = "";
        mDrawerList = (ListView)findViewById(R.id.drawerlistView);
        mAboutList = (ListView)findViewById(R.id.aboutlistView);
        final String[] aboutvalues = new String[]{ "關於我們"};
        final String[] values = new String[]{ "學期課表", "學期成績", "缺曠系統", "校車系統", "校園資訊" };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.menulistview_item, values){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                this,R.layout.menulistview_item, aboutvalues){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                        initCourse(false, false);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initLeave1(false, false);
                        break;
                    case 3:
                        initBus();
                        break;
                    case 4:
                        initEvent1(true);
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

    public void initSelect(){
        setContentView(R.layout.select);
        ListView selectListView = (ListView) findViewById(R.id.listView);
        TextView cancel = (TextView) findViewById(R.id.cancel);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.select_item, SemesterList){
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
                    convertView = mInflater.inflate(R.layout.select_item, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.textView);
                    holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder)convertView.getTag();
                }
                holder.textView.setText(SemesterList.get(position));
                if (SemesterValue.get(position).equals(ymsScore))
                    holder.imageView.setBackgroundResource(R.drawable.ic_done_black_48dp);
                else
                    holder.imageView.setBackgroundColor(Color.TRANSPARENT);
                return convertView;
            }
        };
        selectListView.setAdapter(adapter);
        selectListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Boolean cancel = false;
                if (ymsScore.equals(SemesterValue.get(position)))
                    cancel = true;
                ymsScore = SemesterValue.get(position);
                if (_fncid.equals("AG222"))
                    initCourse(true, cancel);
                else if (_fncid.equals("AG008"))
                    initScore(true, cancel);
                else if (_fncid.equals("AK002"))
                    initLeave1(true, cancel);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_fncid.equals("AG222"))
                    initCourse(true, true);
                else if (_fncid.equals("AG008"))
                    initScore(true, true);
                else if (_fncid.equals("AK002"))
                    initLeave1(true, true);
            }
        });
    }

    public void initSelectSemester(){
        SelectTextView = (TextView) findViewById(R.id.selecttextView);
        for (int i = 0; i < SemesterValue.size(); i ++)
            if (SemesterValue.get(i).equals(ymsScore))
            {
                SelectTextView.setText(SemesterList.get(i));
                break;
            }
    }

    public void initCourse(boolean select, boolean cancel){
        setContentView(R.layout.course);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);

        RelativeLayout Select = (RelativeLayout) findViewById(R.id.select);
        Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _fncid = "AG222";
                initSelect();
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
                this,R.layout.menulistview_item, values){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                this,R.layout.menulistview_item, aboutvalues){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                        initScore(false, false);
                        break;
                    case 1:
                        initLeave1(false, false);
                        break;
                    case 2:

                        break;
                    case 3:
                        initEvent1(true);
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
        if (!select)
            new Thread(ReadSemesterRunnable).start();
        else
        {
            if (!cancel)
            {
                ReadCourseHandler.sendEmptyMessage(-1);
                new Thread(ReadCourseRunnable).start();
                initSelectSemester();
            }
            else
            {
                initSelectSemester();
                addCourse();
            }
        }
    }

    public void initScore(boolean select, boolean cancel){
        setContentView(R.layout.score);

        RelativeLayout Select = (RelativeLayout) findViewById(R.id.select);
        Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _fncid = "AG008";
                initSelect();
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
                this,R.layout.menulistview_item, values){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                this,R.layout.menulistview_item, aboutvalues){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                        initCourse(false, false);
                        break;
                    case 1:
                        initLeave1(false, false);
                        break;
                    case 2:

                        break;
                    case 3:
                        initEvent1(true);
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
        if (!select)
            new Thread(ReadSemesterRunnable).start();
        else
        {
            if (!cancel)
            {
                ReadScoreHandler.sendEmptyMessage(-1);
                new Thread(ReadScoreRunnable).start();
                initSelectSemester();
            }
            else
            {
                initSelectSemester();
                addScore();
            }
        }
    }

    public void initLeave1(boolean select, boolean cancel){
        setContentView(R.layout.leave1);

        RelativeLayout Select = (RelativeLayout) findViewById(R.id.select);
        Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _fncid = "AK002";
                initSelect();
            }
        });

        RelativeLayout Page2 = (RelativeLayout) findViewById(R.id.RelativeLayout2);
        Page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initLeave2();
            }
        });

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);

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
        final String[] values = new String[]{ "學期課表", "學期成績", "校車系統", "校園資訊" };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.menulistview_item, values){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                this,R.layout.menulistview_item, aboutvalues){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                        initCourse(false, false);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:

                        break;
                    case 3:
                        initEvent1(true);
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

        ReadLeaveRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (!CheckLoginState())
                        ReLogin();

                    List<NameValuePair> params = new LinkedList<>();
                    params.add(new BasicNameValuePair("yms", ymsScore));
                    params.add(new BasicNameValuePair("arg01", ymsScore.split(",")[0]));
                    params.add(new BasicNameValuePair("arg02", ymsScore.split(",")[1]));
                    params.add(new BasicNameValuePair("spath", "ak_pro/ak002_01.jsp?"));
                    Document document = Jsoup.parse(post_url_contents(_leaveSearchUrl, params, cookieStore));

                    LeaveList = new ArrayList<>();
                    for (int i = 2; i <= Xsoup.compile("/html/body/table[2]/tbody/tr").evaluate(document).list().size(); i++)
                    {

                        String getData = Xsoup.compile("/html/body/table[2]/tbody/tr[" + i + "]").evaluate(document).getElements().text();
                        if (getData.split(" ").length == 19)
                            LeaveList.add(new LeaveList(getData.split(" ")[2],
                                    getData.split(" ")[3] + getData.split(" ")[4],
                                    getData.split(" ")[5],
                                    getData.split(" ")[6],
                                    getData.split(" ")[7],
                                    getData.split(" ")[8],
                                    getData.split(" ")[9],
                                    getData.split(" ")[10],
                                    getData.split(" ")[11],
                                    getData.split(" ")[12],
                                    getData.split(" ")[13],
                                    getData.split(" ")[14],
                                    getData.split(" ")[15],
                                    getData.split(" ")[16],
                                    getData.split(" ")[17],
                                    getData.split(" ")[18]));
                        else if (getData.split(" ").length == 18)
                            LeaveList.add(new LeaveList(getData.split(" ")[1],
                                    getData.split(" ")[2] + getData.split(" ")[3],
                                    getData.split(" ")[4],
                                    getData.split(" ")[5],
                                    getData.split(" ")[6],
                                    getData.split(" ")[7],
                                    getData.split(" ")[8],
                                    getData.split(" ")[9],
                                    getData.split(" ")[10],
                                    getData.split(" ")[11],
                                    getData.split(" ")[12],
                                    getData.split(" ")[13],
                                    getData.split(" ")[14],
                                    getData.split(" ")[15],
                                    getData.split(" ")[16],
                                    getData.split(" ")[17]));
                    }
                    ReadLeaveHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        _fncid = "AK002";
        if (!select)
            new Thread(ReadSemesterRunnable).start();
        else
        {
            if (!cancel)
            {
                ReadLeaveHandler.sendEmptyMessage(-1);
                new Thread(ReadLeaveRunnable).start();
                initSelectSemester();
            }
            else
            {
                initSelectSemester();
                addLeave();
            }
        }
    }

    public void initLeave2(){
        setContentView(R.layout.leave2);

        RelativeLayout Page1 = (RelativeLayout) findViewById(R.id.relativeLayout);
        Page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initLeave1(true, true);
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
        final String[] values = new String[]{ "學期課表", "學期成績", "校車系統", "校園資訊" };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.menulistview_item, values){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                this,R.layout.menulistview_item, aboutvalues){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                        initCourse(false, false);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:

                        break;
                    case 3:
                        initEvent1(true);
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

        _fncid = "";
    }

    public void initEvent1(final boolean _isLogin){
        setContentView(R.layout.event1);

        RelativeLayout Page2 = (RelativeLayout) findViewById(R.id.RelativeLayout2);
        Page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEvent2(_isLogin);
            }
        });

        RelativeLayout Page3 = (RelativeLayout) findViewById(R.id.RelativeLayout3);
        Page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEvent3(_isLogin);
            }
        });

        ImageView Logout = (ImageView) findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_isLogin)
                    initLogout();
                else
                    initLogin();
            }
        });
        mDrawerList = (ListView)findViewById(R.id.drawerlistView);
        mAboutList = (ListView)findViewById(R.id.aboutlistView);
        final String[] aboutvalues = new String[]{ "關於我們"};
        final String[] values = new String[]{ "學期課表", "學期成績", "缺曠系統", "校車系統" };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.menulistview_item, values){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                this,R.layout.menulistview_item, aboutvalues){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
        if (_isLogin)
            mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse(false, false);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initLeave1(false, false);
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

        _fncid = "";
    }

    public void initEvent2(final boolean _isLogin){
        setContentView(R.layout.event2);

        RelativeLayout Page1 = (RelativeLayout) findViewById(R.id.RelativeLayout);
        Page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEvent1(_isLogin);
            }
        });

        RelativeLayout Page3 = (RelativeLayout) findViewById(R.id.RelativeLayout3);
        Page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEvent3(_isLogin);
            }
        });

        ImageView Logout = (ImageView) findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_isLogin)
                    initLogout();
                else
                    initLogin();
            }
        });
        mDrawerList = (ListView)findViewById(R.id.drawerlistView);
        mAboutList = (ListView)findViewById(R.id.aboutlistView);
        final String[] aboutvalues = new String[]{ "關於我們"};
        final String[] values = new String[]{ "學期課表", "學期成績", "缺曠系統", "校車系統" };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.menulistview_item, values){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                this,R.layout.menulistview_item, aboutvalues){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
        if (_isLogin)
            mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse(false, false);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initLeave1(false, false);
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

        _fncid = "";
    }

    public void initEvent3(final boolean _isLogin){
        setContentView(R.layout.event3);

        RelativeLayout Page1 = (RelativeLayout) findViewById(R.id.RelativeLayout);
        Page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEvent1(_isLogin);
            }
        });

        RelativeLayout Page2 = (RelativeLayout) findViewById(R.id.RelativeLayout2);
        Page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEvent2(_isLogin);
            }
        });

        ImageView Logout = (ImageView) findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_isLogin)
                    initLogout();
                else
                    initLogin();
            }
        });
        mDrawerList = (ListView)findViewById(R.id.drawerlistView);
        mAboutList = (ListView)findViewById(R.id.aboutlistView);
        final String[] aboutvalues = new String[]{ "關於我們"};
        final String[] values = new String[]{ "學期課表", "學期成績", "缺曠系統", "校車系統" };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,R.layout.menulistview_item, values){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
                this,R.layout.menulistview_item, aboutvalues){
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
                    convertView = mInflater.inflate(R.layout.menulistview_item, null);
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
        if (_isLogin)
            mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse(false, false);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initLeave1(false, false);
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

        _fncid = "";
    }

    private void initBus()
    {
        BusLoginRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    get_url_contents("http://bus.kuas.edu.tw/" , null, cookieStore);
                    String n = runScript(BusJs + get_url_contents("http://bus.kuas.edu.tw/API/Scripts/a1" , null, cookieStore), "loginEncryption", new String[]{Uid, Pwd});
                    List<NameValuePair> params = new LinkedList<>();
                    params.add(new BasicNameValuePair("account", Uid));
                    params.add(new BasicNameValuePair("password", Pwd));
                    params.add(new BasicNameValuePair("n", n));
                    System.out.println(post_url_contents(_busLoginUrl , params, cookieStore));
                    JSONObject jsonObj = new JSONObject(post_url_contents(_busLoginUrl , params, cookieStore));
                    System.out.println(jsonObj.optString("success"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(BusLoginRunnable).start();
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

    private Handler ReadLeaveHandler = new Handler() {
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
                    addLeave();
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
                    initSelectSemester();
                    if (_fncid.equals("AG008"))
                        new Thread(ReadScoreRunnable).start();
                    else if (_fncid.equals("AG222"))
                        new Thread(ReadCourseRunnable).start();
                    else if (_fncid.equals("AK002"))
                        new Thread(ReadLeaveRunnable).start();
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

    public void addLeave() {
        TableLayout table = (TableLayout) findViewById(R.id.tablelayout);
        table.setStretchAllColumns(true);
        table.removeAllViews();

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);
        if (LeaveList.size() == 0)
        {
            TableRow tablerow = new TableRow(MainActivity.this);
            final TextView testview = new TextView(MainActivity.this);
            testview.setTextSize(14);
            testview.setGravity(Gravity.CENTER);
            testview.setText("本學期無缺曠課紀錄");
            testview.setBackgroundResource(R.drawable.tablelayout_oneitem);
            tablerow.addView(testview,new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            table.addView(tablerow);
            return;
        }

        TableRow tablerowx = new TableRow(MainActivity.this);
        String[] titles;

        if (getResources().getConfiguration().orientation == 2) //橫向
        {
            textView.setVisibility(View.GONE);
            titles = new String[]{"日期", "M", "1", "2", "3", "4", "A", "5", "6", "7", "8", "B", "11", "12", "13", "14"};
        }
        else //垂直
        {
            textView.setVisibility(View.VISIBLE);
            titles = new String[]{"日期", "M", "1", "2", "3", "4", "A", "5", "6", "7", "8"};
        }

        for (int i = 0; i < titles.length; i++)
        {
            TextView title = new TextView(MainActivity.this);
            title.setText(titles[i]);
            title.setTextColor(getResources().getColor(R.color.blue));
            title.setTextSize(14);
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

        for (int i = 0; i < LeaveList.size(); i++) {
            TableRow tablerow = new TableRow(MainActivity.this);
            for (int j = 0; j < titles.length; j++) {
                final TextView testview = new TextView(MainActivity.this);
                testview.setTextSize(14);

                testview.setTextColor(getResources().getColor(R.color.grey));
                switch (j)
                {
                    case 0:
                        testview.setText(LeaveList.get(i)._Time);
                        break;
                    case 1:
                        testview.setText(LeaveList.get(i)._M);
                        break;
                    case 2:
                        testview.setText(LeaveList.get(i)._1);
                        break;
                    case 3:
                        testview.setText(LeaveList.get(i)._2);
                        break;
                    case 4:
                        testview.setText(LeaveList.get(i)._3);
                        break;
                    case 5:
                        testview.setText(LeaveList.get(i)._4);
                        break;
                    case 6:
                        testview.setText(LeaveList.get(i)._A);
                        break;
                    case 7:
                        testview.setText(LeaveList.get(i)._5);
                        break;
                    case 8:
                        testview.setText(LeaveList.get(i)._6);
                        break;
                    case 9:
                        testview.setText(LeaveList.get(i)._7);
                        break;
                    case 10:
                        testview.setText(LeaveList.get(i)._8);
                        break;
                    case 11:
                        testview.setText(LeaveList.get(i)._B);
                        break;
                    case 12:
                        testview.setText(LeaveList.get(i)._11);
                        break;
                    case 13:
                        testview.setText(LeaveList.get(i)._12);
                        break;
                    case 14:
                        testview.setText(LeaveList.get(i)._13);
                        break;
                    case 15:
                        testview.setText(LeaveList.get(i)._14);
                        break;
                }

                testview.setGravity(Gravity.CENTER);
                if (j == 0)
                {
                    if (i == LeaveList.size()-1)
                        testview.setBackgroundResource(R.drawable.tablelayout_bottom_left);
                    else
                        testview.setBackgroundResource(R.drawable.tablelayout_normal_left);
                }
                else if (j == titles.length-1)
                {
                    if (i == LeaveList.size()-1)
                        testview.setBackgroundResource(R.drawable.tablelayout_bottom_right);
                    else
                        testview.setBackgroundResource(R.drawable.tablelayout_normal_right);
                }
                else
                {
                    if (i == LeaveList.size()-1)
                        testview.setBackgroundResource(R.drawable.tablelayout_bottom_center);
                    else
                        testview.setBackgroundResource(R.drawable.tablelayout_normal_center);
                }
                tablerow.addView(testview, new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            }
            table.addView(tablerow);
        }
    }

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
            testview.setTextSize(14);
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
            title.setTextSize(14);
            title.setGravity(Gravity.CENTER);
            if (i == 0)
                title.setBackgroundResource(R.drawable.course_top_left);
            else if (i == titles.length-1)
                title.setBackgroundResource(R.drawable.course_top_right);
            else
                title.setBackgroundResource(R.drawable.course_top_center);
            tablerowx.addView(title);
        }
        table.addView(tablerowx);

        String[] titles2 = {"M", "第1節", "第2節", "第3節", "第4節", "A", "第5節", "第6節", "第7節", "第8節", "B", "第11節", "第12節", "第13節", "第14節"};
        for (int i = 0; i < y; i++) {
            TableRow tablerow = new TableRow(MainActivity.this);
            for (int j = 0; j < x; j++) {
                final TextView testview = new TextView(MainActivity.this);
                testview.setTextSize(16);

                if (j == 0)
                {
                    testview.setTextColor(getResources().getColor(R.color.blue));
                    testview.setTextSize(14);
                    testview.setText(titles2[i]);
                }
                else
                {
                    testview.setTextColor(getResources().getColor(R.color.grey));
                    if (CourseList.get(i).get(j - 1).ID.length() > 0)
                        testview.setText(CourseList.get(i).get(j - 1).ID.substring(0,2));
                    else
                        testview.setText("　　");
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
                        testview.setBackgroundResource(R.drawable.course_bottom_left);
                    else
                        testview.setBackgroundResource(R.drawable.course_normal_left);
                }
                else if (j == x-1)
                {
                    if (i == y-1)
                        testview.setBackgroundResource(R.drawable.course_bottom_right);
                    else
                        testview.setBackgroundResource(R.drawable.course_normal_right);
                }
                else
                {
                    if (i == y-1)
                        testview.setBackgroundResource(R.drawable.course_bottom_center);
                    else
                        testview.setBackgroundResource(R.drawable.course_normal_center);
                }
                tablerow.addView(testview, new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
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

    public String runScript(String js, String functionName, Object[] functionParams) {
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        try {
            Scriptable scope = rhino.initStandardObjects();

            ScriptableObject.putProperty(scope, "javaContext", Context.javaToJS(MainActivity.this, scope));
            ScriptableObject.putProperty(scope, "javaLoader", Context.javaToJS(MainActivity.class.getClassLoader(), scope));

            rhino.evaluateString(scope, js, "MainActivity", 1, null);

            Function function = (Function) scope.get(functionName, scope);

            Object result = function.call(rhino, scope, scope, functionParams);
            if (result instanceof String) {
                return (String) result;
            } else if (result instanceof NativeJavaObject) {
                return (String) ((NativeJavaObject) result).getDefaultValue(String.class);
            } else if (result instanceof NativeObject) {
                return (String) ((NativeObject) result).getDefaultValue(String.class);
            }
            return result.toString();
        } finally {
            Context.exit();
        }
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
        else if (_fncid.equals("AK002") && !LoadingDialog.isShowing())
            addLeave();
    }
}
