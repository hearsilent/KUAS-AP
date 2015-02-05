package com.kuas.ap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.alertdialogpro.AlertDialogPro;
import com.alertdialogpro.ProgressDialogPro;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

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
import org.json.JSONArray;
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
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import us.codecraft.xsoup.Xsoup;

import static android.view.Gravity.CENTER;
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

    private String api_server = "http://kuas.grd.idv.tw:14768/";

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

    private boolean OnCreateCheck = false;

    // Server Status
    Runnable CheckServerStatusRunnable;
    boolean ap_status = false;
    boolean leave_status = false;
    boolean bus_status = false;

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
    String OfflineCourseData = "";
    boolean isOfflineCourse = false;

    // Leave
    Runnable ReadLeaveRunnable;
    ArrayList<LeaveList> LeaveList = new ArrayList<>();
    boolean isNightLeave = false;
    String startTime = "";
    String endTime = "";
    String leaveType = "";
    String leaveReason = "";
    String leavePeriod = "";
    ArrayList<String> leavePeriodMap = new ArrayList<>();
    Runnable LeaveSubmitRunnable;

    // Bus
    Runnable BusLoginRunnable;
    Runnable ReadBusRunnable;
    Runnable BusReserveRunnable;
    Runnable BusBookingRunnable;
    String BusDate = "";
    String BusEndStation = "燕巢";
    String _busId = "";
    String _busAction = "";
    ArrayList<BusList> BusList = new ArrayList<>();
    ArrayList<BusList> BusReserveList = new ArrayList<>();

    // Event
    Runnable ReadNotificationRunnable;
    ArrayList<NotificationList> NotificationList = new ArrayList<>();
    Integer NotificationPage = 1;
    ArrayList<PhoneList> PhoneList = new ArrayList<>();
    String scheduleData = "[{\"events\":[\"(2/1) 103學年度第2學期開始日\",\"(2/3 - 2/5) 寄發103學年度第1學期學生成績單\",\"(2/4) 核對103學年度第1學期成績優良排名表\",\"(2/4) 核發103學年度寒畢畢業證書\",\"(2/5 - 2/9) 103學年度第1學期學業成績優良排名表送生輔組協查有無記過紀錄\",\"(2/10 - 2/16) 第1次公告103學年度第1學期學業成績優良名單\"],\"week\":\"寒\"},{\"events\":[\"(2/16) 新進教師研習會\",\"(2/18 - 2/23) 春節放假\",\"(2/17 - 2/24) 第2次公告103學年度第1學期學業成績優良名單\"],\"week\":\"預備週\"},{\"events\":[\"(2/23) 補假一天(補2/21春節初三)\",\"(2/25) 日間部、進修推廣處開學\",\"(2/27) 補假一天(補2/28和平紀念日)\",\"(2/24) 教學研討會（導師會議、導師輔導知能研習）\",\"(2/24) 研究生辦理103學年度第1學期離校手續截止日\",\"(2/24) 註冊繳費截止日\",\"(2/25) 網路公布103學年度第2學期加退選日程及相關辦法\",\"(2/25) 輔系、雙主修、轉學生學分抵免申請開始\",\"(2/25) 校際選課開始申請\",\"(2/25 - 3/4) 通知103學年度第1學期學業成績優良學生至學校網站登載銀行帳號(限郵局及台灣企銀)\",\"(2/25) 研究生自完成註冊手續後開始辦理學位考試申請\"],\"week\":\"第一週\"},{\"events\":[\"(3/4) 轉學生學分抵免申請截止日\",\"(3/4 - 3/11) 日間部學生加退選課申請作業(選課時間另行公布)\",\"(3/4) 輔系、雙主修申請截止日\",\"(3/6) 校際選課截止日\"],\"week\":\"第二週\"},{\"events\":[\"(3/12) 103學年度第2學期人工加掛選課申請截止日\"],\"week\":\"第三週\"},{\"events\":[\"(3/18) 103學年度第2學期第1次教務會議\"],\"week\":\"第四週\"},{\"events\":[\"(3/27 - 3/31) 學生加退選課繳費\"],\"week\":\"第五週\"},{\"events\":[\"(4/3) 補假一天(補4/4兒童節)\",\"(3/30) 加退選結束教師自行列印點名單及成績冊(web)\",\"(3/30 - 4/8) 教師上網登錄期中考考試時間\",\"(3/30 - 4/2) 核算103學年度第2學期教師鐘點費\",\"(4/1) 學生逕修讀博士學位開始申請\"],\"week\":\"第六週\"},{\"events\":[\"(4/6) 補假一天(補4/5民族掃墓節)\",\"(4/7) 學生辦理休、退學學雜費退2/3截止日\",\"(4/8 - 4/14) 103學年度暑修意願網路調查\"],\"week\":\"第七週\"},{\"events\":[\"(4/13 - 4/25) 上網公布期中考考試時間、開放同學查詢\",\"(4/15) 學生逕修讀博士學位申請截止日\",\"(4/15 - 5/3) 教師登錄期中成績暨預警作業\",\"(4/17) 教師期中考試卷申印製卷截止日\"],\"week\":\"第八週\"},{\"events\":[\"(4/20 - 4/25) 日間部、進修推廣處期中考試\"],\"week\":\"第九週\"},{\"events\":[\"(4/27) 103學年度第三次校務會議\",\"(4/27) 103學年度第2學期停修課程開始申請\",\"(4/27) 登錄教師研究計畫案及義務授課減授時數\",\"(4/27 - 5/1) 第一次修訂104學年度第1學期註冊須知\",\"(4/28) 公告103學年度暑修初步課表\",\"(4/30) 103學年度第2學期研究生學位考試申請期限截止日\",\"(5/1) 日間部大學部學生轉系(組)開始申請\",\"(5/2 - 5/3) 104學年度四技統一入學測驗考試\"],\"week\":\"第十週\"},{\"events\":[\"(5/3) 104學年度二技統一入學測驗考試\",\"(5/4 - 5/8) 103學年度暑修網路選課\",\"(5/3) 教師登錄期中成績暨預警作業截止日\"],\"week\":\"第十一週\"},{\"events\":[\"(5/11 - 5/13) 發放期中預警學生名單予各系、班級導師、任課老師\",\"(5/11 - 5/15) 第二次修訂104學年度第1學期註冊須知\",\"(5/11 - 5/31) 導師填報期中預警輔導紀錄表(web)\",\"(5/15) 103學年度第2學期停修課程申請截止日\",\"(5/15) 日間部大學部學生轉系(組)申請期限截止日\"],\"week\":\"第十二週\"},{\"events\":[\"(5/19) 學生辦理休、退學學雜費退1/3截止日\",\"(5/20 - 5/22) 寄發104學年度第1學期復學通知\"],\"week\":\"第十三週\"},{\"events\":[\"(5/25 - 5/27) 核算停修後教師鐘點費\",\"(5/27) 發放舊生註冊須知\"],\"week\":\"第十四週\"},{\"events\":[\"(6/3) 103學年度第2學期第2次教務會議\",\"(6/1 - 6/5) 103學年度暑修繳費\",\"(6/1 - 6/10) 教師上網登錄期末考時間\",\"(6/4) 開放上網查詢104學年度第1學期課程表\"],\"week\":\"第十五週\"},{\"events\":[\"(6/13) 畢業典禮\",\"(6/8 - 6/12) 日間部學生104學年度第1學期選課登記志願(初選第一階段)\"],\"week\":\"第十六週\"},{\"events\":[\"(6/19) 補假一天(補6/20端午節)\",\"(6/15) 103學年度第四次校務會議\",\"(6/15 - 6/27) 上網公佈期末考時間，開放學生查詢\",\"(6/16 - 6/23) 日間部學生104學年度第1學期選課電腦篩選\",\"(6/18) 學生期末考扣考資料通知學生、家長、老師\",\"(6/18) 教師期末考試卷申印製卷截止日\"],\"week\":\"第十七週\"},{\"events\":[\"(6/24 - 6/30) 日間部、進修推廣處期末考試\",\"(6/24 - 6/26) 日間部學生104學年度第1學期選課電腦篩選分發結果公告\"],\"week\":\"第十八週\"},{\"events\":[\"(6/29 - 7/2) 日間部學生104學年度第1學期初選第二階段選課\",\"(7/5) 教師送交畢業班學期考試成績截止日\",\"(7/6 - 7/8) 本學期修課不及格者辦理暑修報名並繳費\",\"(7/6 - 7/8) 外校生至本校暑修選課報名並同時繳費\",\"(7/7) 教師送交103學年度第2學期學生學期成績截止日\",\"(7/8 - 7/10) 彙算103學年度第2學期學生學業成績\",\"(7/13) 暑修開始上課，預計8/22上課結束\",\"(7/14) 寄發103學年度第2學期退學通知\",\"(7/20) 核發103學年度畢業生畢業證書\",\"(7/20 - 7/22) 寄發103學年度第2學期學生成績單\",\"(7/31) 103學年度第2學期研究生學位考試截止日\",\"(7/31) 103學年度第2學期結束日\"],\"week\":\"暑\"}]";

    // News
    Integer news_id = -1;

    // Select
    boolean isSelecting = false;

    // Debug
    public static final boolean NewsDebug = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ReadSemesterRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    ReadSemesterHandler.sendEmptyMessage(-1);

                    if (!CheckLoginState())
                    {
                        if (!ReLogin())
                        {
                            ReLoginHandler.sendEmptyMessage(-1);
                            return;
                        }
                    }

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

        CheckServerStatusRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    ap_status = false;
                    leave_status = false;
                    bus_status = false;
                    try {
                        JSONArray jsonObj = new JSONArray(get_url_contents(api_server + "status", null, cookieStore));
                        ap_status = jsonObj.getBoolean(0);
                        if (jsonObj.getInt(1) == 200)
                            leave_status = true;
                        else
                            leave_status = false;
                        if (jsonObj.getInt(2) == 200)
                            bus_status = true;
                        else
                            bus_status = false;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    CheckServerStatusHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        if (!OnCreateCheck)
        {
            initLogin();
            OnCreateCheck = true;
        }
    }

    public boolean CheckVersion()
    {
        String ServerVersion = get_url_contents(api_server + "android_version", null, cookieStore);
        String ClientVersion = "";

        try{
            PackageInfo pkgInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            ClientVersion = pkgInfo.versionName;
            TextView version = (TextView) findViewById(R.id.version);
            version.setText("v" + ClientVersion);
            //ClientVersion += "." + pkgInfo.versionCode;

            if (Integer.parseInt(ServerVersion.split("\\.")[0]) > Integer.parseInt(ClientVersion.split("\\.")[0]))
                return true;
            else
            {
                if (Integer.parseInt(ServerVersion.split("\\.")[0]) == Integer.parseInt(ClientVersion.split("\\.")[0]))
                {
                    if (Integer.parseInt(ServerVersion.split("\\.")[1]) > Integer.parseInt(ClientVersion.split("\\.")[1]))
                    {
                        return true;
                    }
                    else
                    {
                        if (Integer.parseInt(ServerVersion.split("\\.")[1]) == Integer.parseInt(ClientVersion.split("\\.")[1]))
                        {
                            if (Integer.parseInt(ServerVersion.split("\\.")[2]) > Integer.parseInt(ClientVersion.split("\\.")[2]))
                                return true;
                            else
                                return false;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    return false;
                }
            }

        } catch (Exception e) {
            return false;
        }
    }

    public Boolean CheckLoginState()
    {
        try {
            // Cilent
            /*
            Document document = Jsoup.parse(get_url_contents(_usernameUrl, null, cookieStore));
            if (Xsoup.compile("/html/body/div[1]/div/div[3]/span[3]").evaluate(document).get() != null)
                return true;
            else
                return false;
            */

            // Server
            if (post_url_contents(api_server + "ap/is_login", null, cookieStore).equals("true"))
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
        // Client
        cookieStore = new BasicCookieStore();
        List<NameValuePair> params = new LinkedList<>();
        params.add(new BasicNameValuePair("uid", Uid));
        params.add(new BasicNameValuePair("pwd", Pwd));
        post_url_contents(_loginUrl, params, cookieStore);

        // Server
        params.clear();
        params.add(new BasicNameValuePair("username", UserNameEditText.getText().toString()));
        params.add(new BasicNameValuePair("password", PasswordEditText.getText().toString()));
        post_url_contents(api_server + "ap/login", params, cookieStore);
        return CheckLoginState();
    }

    public void initServerStatus(){
        try {
            TextView ap = (TextView) findViewById(R.id.ap);
            TextView leave = (TextView) findViewById(R.id.leave);
            TextView bus = (TextView) findViewById(R.id.bus);

            if (ap_status)
                ap.setTextColor(getResources().getColor(R.color.green));
            else
                ap.setTextColor(getResources().getColor(R.color.red));
            if (leave_status)
                leave.setTextColor(getResources().getColor(R.color.green));
            else
                leave.setTextColor(getResources().getColor(R.color.red));
            if (ap_status)
                bus.setTextColor(getResources().getColor(R.color.green));
            else
                bus.setTextColor(getResources().getColor(R.color.red));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initLogin(){
        setContentView(R.layout.login);

        _fncid = "";
        UserNameEditText = (EditText) findViewById(R.id.Username);
        PasswordEditText = (EditText) findViewById(R.id.Password);
        SignInButton = (Button) findViewById(R.id.SignIn);
        RememberPass = (CheckBox) findViewById(R.id.RememberPass);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        LoadingDialog = new ProgressDialogPro(this, R.style.Theme_AlertDialogPro_Material_Light);

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
        final String[] aboutvalues = new String[]{  "關於我們" };
        final String[] values = new String[]{ "離線課表", "校園資訊" };
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
        mAboutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initAbout(false);
                        break;
                }
            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse(false, false, false);
                        break;
                    case 1:
                        initEvent1(false, true);
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

        if (CheckVersion())
        {
            AlertDialogPro.Builder builder = CustomDialog("發現新版本", "要到「Google Play」安裝新版嗎？", false);
            builder.setPositiveButton("安裝新版本", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.kuas.ap"));
                            startActivity(browserIntent);
                            finish();
                            onDestroy();
                        }
                    }).
                    setNegativeButton("離開程式", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            onDestroy();
                        }
                    }).setCancelable(false).show();
            return;
        }

        LoginRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    cookieStore = new BasicCookieStore();
                    LoginHandler.sendEmptyMessage(LoginInit);
                    List<NameValuePair> params = new LinkedList<>();
                    // Cilent
                    params.add(new BasicNameValuePair("uid", UserNameEditText.getText().toString()));
                    params.add(new BasicNameValuePair("pwd", PasswordEditText.getText().toString()));
                    post_url_contents(_loginUrl, params, cookieStore);

                    // Server
                    params.clear();
                    params.add(new BasicNameValuePair("username", UserNameEditText.getText().toString()));
                    params.add(new BasicNameValuePair("password", PasswordEditText.getText().toString()));
                    post_url_contents(api_server + "ap/login", params, cookieStore);
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

        new Thread(CheckServerStatusRunnable).start();
        showNews();
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
        mAboutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initAbout(true);
                        break;
                }
            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse(false, false, true);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initLeave1(false, false);
                        break;
                    case 3:
                        initBus1(true);
                        break;
                    case 4:
                        initEvent1(true, true);
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

        initServerStatus();
    }

    public void initSelect(){
        setContentView(R.layout.select);
        isSelecting = true;

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
                isSelecting = false;
                if (_fncid.equals("AG222"))
                    initCourse(true, cancel, true);
                else if (_fncid.equals("AG008"))
                    initScore(true, cancel);
                else if (_fncid.equals("AK002"))
                    initLeave1(true, cancel);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelecting = false;
                if (_fncid.equals("AG222"))
                    initCourse(true, true, true);
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

    public void initReLogin(){
        setContentView(R.layout.relogin);

        ImageView Logout = (ImageView) findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initLogin();
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

        _fncid = "";
    }

    public void initCourse(boolean select, boolean cancel, final boolean _isLogin){
        if (_isLogin)
            setContentView(R.layout.course);
        else
            setContentView(R.layout.offlinecourse);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);

        isOfflineCourse = !_isLogin;

        if (_isLogin)
        {
            RelativeLayout Select = (RelativeLayout) findViewById(R.id.select);
            Select.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _fncid = "AG222";
                    initSelect();
                }
            });
        }

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
        final String[] values;
        if (_isLogin)
            values = new String[]{ "學期成績", "缺曠系統", "校車系統", "校園資訊" };
        else
            values = new String[]{ "校園資訊" };
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
        mAboutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initAbout(true);
                        break;
                }
            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        if (_isLogin)
                            initScore(false, false);
                        else
                            initEvent1(false, true);
                        break;
                    case 1:
                        initLeave1(false, false);
                        break;
                    case 2:
                        initBus1(true);
                        break;
                    case 3:
                        initEvent1(true, true);
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

        _fncid = "AG222";
        ReadCourseRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (!CheckLoginState())
                    {
                        if (!ReLogin())
                        {
                            ReLoginHandler.sendEmptyMessage(-1);
                            return;
                        }
                    }


                    List<NameValuePair> params = new LinkedList<>();

                    // Client
                    /*
                    params.add(new BasicNameValuePair("yms", ymsScore));
                    params.add(new BasicNameValuePair("arg01", ymsScore.split(",")[0]));
                    params.add(new BasicNameValuePair("arg02", ymsScore.split(",")[1]));
                    params.add(new BasicNameValuePair("spath", "ag_pro/ag222.jsp?"));
                    Document document = Jsoup.parse(post_url_contents(_courseUrl, params, cookieStore));
                    */

                    isHolidayClass = false;
                    isHolidayNightClass = false;
                    isNightClass = false;
                    CourseList = new ArrayList<>();

                    // Server
                    params.add(new BasicNameValuePair("fncid", _fncid.toLowerCase()));
                    params.add(new BasicNameValuePair("arg01", ymsScore.split(",")[0]));
                    params.add(new BasicNameValuePair("arg02", ymsScore.split(",")[1]));
                    try {
                        OfflineCourseData = post_url_contents(api_server + "ap/query", params, cookieStore);
                        JSONArray jsonObj = new JSONArray(OfflineCourseData);
                        for (int i = 0; i < jsonObj.getJSONObject(0).length(); i++) {
                            JSONObject item = jsonObj.getJSONObject(0).getJSONObject(Integer.toString(i));
                            ArrayList<CourseList> CourseList2 = new ArrayList<>();
                            for (int j = 1; j < 8; j ++)
                            {
                                JSONObject itemdata = item.getJSONObject(Integer.toString(j));
                                if (j >= 6 && !itemdata.getString("course_name").equals(""))
                                {
                                    isHolidayClass = true;
                                    if (i >= 10)
                                        isHolidayNightClass = true;
                                }
                                else if (!itemdata.getString("course_name").equals("") && i >= 10)
                                    isNightClass = true;

                                CourseList2.add(new CourseList(itemdata.getString("course_name"),
                                        itemdata.getString("course_teacher"),
                                        itemdata.getString("course_classroom"),
                                        item.getString("time")));
                            }
                            CourseList.add(CourseList2);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Cilent
                    /*
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
                    */
                    ReadCourseHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        final TextView ymsTextView = (TextView) findViewById(R.id.selecttextView);
        RelativeLayout OffineScore = (RelativeLayout) findViewById(R.id.OfflineCourse);
        OffineScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_isLogin)
                {
                    AlertDialogPro.Builder builder = CustomDialog("離線課表", "是否要將「" + ymsTextView.getText().toString() + "」設為離線課表？", false);
                    builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    SharedPreferences setting = getSharedPreferences("KUAS AP", 0);
                                    setting.edit().putString("OfflineCourse", OfflineCourseData).apply();
                                }
                            }).
                            setNegativeButton("取消", null).setCancelable(false).show();
                }
                else
                {
                    AlertDialogPro.Builder builder = CustomDialog("離線課表", "是否要將離線課表清除？", false);
                    builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    SharedPreferences setting = getSharedPreferences("KUAS AP", 0);
                                    setting.edit().putString("OfflineCourse", "").apply();
                                    addOfflineCourse();
                                }
                            }).
                            setNegativeButton("取消", null).setCancelable(false).show();
                }
            }
        });


        if (_isLogin)
        {
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
        else
        {
            addOfflineCourse();
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
        mAboutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initAbout(true);
                        break;
                }
            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse(false, false, true);
                        break;
                    case 1:
                        initLeave1(false, false);
                        break;
                    case 2:
                        initBus1(true);
                        break;
                    case 3:
                        initEvent1(true, true);
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

        _fncid = "AG008";
        ReadScoreRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (!CheckLoginState())
                    {
                        if (!ReLogin())
                        {
                            ReLoginHandler.sendEmptyMessage(-1);
                            return;
                        }
                    }

                    List<NameValuePair> params = new LinkedList<>();
                    // Client
                    /*
                    params.add(new BasicNameValuePair("yms", ymsScore));
                    params.add(new BasicNameValuePair("arg01", ymsScore.split(",")[0]));
                    params.add(new BasicNameValuePair("arg02", ymsScore.split(",")[1]));
                    params.add(new BasicNameValuePair("spath", "ag_pro/ag008.jsp?"));
                    Document document = Jsoup.parse(post_url_contents(_scoreUrl, params, cookieStore));
                    */

                    ScoreList = new ArrayList<>();
                    Score2List = new ArrayList<>();

                    // Client
                    /*
                    for (int j = 2; j <= Xsoup.compile("/html/body/form/table/tbody/tr").evaluate(document).list().size(); j++)
                        ScoreList.add(new ScoreList(Xsoup.compile("/html/body/form/table/tbody/tr[" + j + "]/td[2]").evaluate(document).getElements().text().trim(),
                                Xsoup.compile("/html/body/form/table/tbody/tr[" + j + "]/td[7]").evaluate(document).getElements().text().trim(),
                                Xsoup.compile("/html/body/form/table/tbody/tr[" + j + "]/td[8]").evaluate(document).getElements().text().trim()));

                    for (String xxx : Xsoup.compile("/html/body/form/table/caption/div/text()").evaluate(document).getElements().text().replace("　　　　", " ").split(" "))
                        Score2List.add(xxx);
                    */

                    // Server
                    params.clear();
                    params.add(new BasicNameValuePair("fncid", _fncid.toLowerCase()));
                    params.add(new BasicNameValuePair("arg01", ymsScore.split(",")[0]));
                    params.add(new BasicNameValuePair("arg02", ymsScore.split(",")[1]));
                    params.add(new BasicNameValuePair("arg03", Uid));
                    try {
                        JSONArray jsonObj = new JSONArray( post_url_contents(api_server + "ap/query", params, cookieStore));
                        for (int i = 0; i < jsonObj.getJSONArray(0).length(); i++) {
                            JSONObject item = jsonObj.getJSONArray(0).getJSONObject(i);
                            ScoreList.add(new ScoreList(item.getString("course_name"),
                                    item.getString("middle_score"),
                                    item.getString("final_score")));
                        }

                        for (int i = 0; i < jsonObj.getJSONArray(1).length(); i++)
                            Score2List.add(jsonObj.getJSONArray(1).get(i).toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ReadScoreHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

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
        mAboutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initAbout(true);
                        break;
                }
            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse(false, false, true);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initBus1(true);
                        break;
                    case 3:
                        initEvent1(true, true);
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

        _fncid = "AK002";
        ReadLeaveRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (!CheckLoginState())
                    {
                        if (!ReLogin())
                        {
                            ReLoginHandler.sendEmptyMessage(-1);
                            return;
                        }
                    }

                    List<NameValuePair> params = new LinkedList<>();
                    LeaveList = new ArrayList<>();
                    isNightLeave = false;

                    // Client
                    /*
                    params.add(new BasicNameValuePair("yms", ymsScore));
                    params.add(new BasicNameValuePair("arg01", ymsScore.split(",")[0]));
                    params.add(new BasicNameValuePair("arg02", ymsScore.split(",")[1]));
                    params.add(new BasicNameValuePair("spath", "ak_pro/ak002_01.jsp?"));
                    Document document = Jsoup.parse(post_url_contents(_leaveSearchUrl, params, cookieStore));

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
                    */

                    // Server
                    params.clear();
                    params.add(new BasicNameValuePair("arg01", ymsScore.split(",")[0]));
                    params.add(new BasicNameValuePair("arg02", ymsScore.split(",")[1]));
                    try {
                        JSONArray jsonObj = new JSONArray(post_url_contents(api_server + "leave", params, cookieStore));
                        for (int i = 1; i < jsonObj.length(); i++) {
                            if (jsonObj.getJSONArray(i).length() == 11)
                            {
                                LeaveList.add(new LeaveList(jsonObj.getJSONArray(i).get(0).toString(),
                                        jsonObj.getJSONArray(i).get(1).toString(),
                                        jsonObj.getJSONArray(i).get(2).toString(),
                                        jsonObj.getJSONArray(i).get(3).toString(),
                                        jsonObj.getJSONArray(i).get(4).toString(),
                                        jsonObj.getJSONArray(i).get(5).toString(),
                                        jsonObj.getJSONArray(i).get(6).toString(),
                                        jsonObj.getJSONArray(i).get(7).toString(),
                                        jsonObj.getJSONArray(i).get(8).toString(),
                                        jsonObj.getJSONArray(i).get(9).toString(),
                                        jsonObj.getJSONArray(i).get(10).toString(),
                                        "",
                                        "",
                                        "",
                                        "",
                                        ""));
                            }
                            else
                            {
                                LeaveList.add(new LeaveList(jsonObj.getJSONArray(i).get(0).toString(),
                                        jsonObj.getJSONArray(i).get(1).toString(),
                                        jsonObj.getJSONArray(i).get(2).toString(),
                                        jsonObj.getJSONArray(i).get(3).toString(),
                                        jsonObj.getJSONArray(i).get(4).toString(),
                                        jsonObj.getJSONArray(i).get(5).toString(),
                                        jsonObj.getJSONArray(i).get(6).toString(),
                                        jsonObj.getJSONArray(i).get(7).toString(),
                                        jsonObj.getJSONArray(i).get(8).toString(),
                                        jsonObj.getJSONArray(i).get(9).toString(),
                                        jsonObj.getJSONArray(i).get(10).toString(),
                                        jsonObj.getJSONArray(i).get(11).toString(),
                                        jsonObj.getJSONArray(i).get(12).toString(),
                                        jsonObj.getJSONArray(i).get(13).toString(),
                                        jsonObj.getJSONArray(i).get(14).toString(),
                                        jsonObj.getJSONArray(i).get(15).toString()));
                                isNightLeave = true;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ReadLeaveHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

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
        mAboutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initAbout(true);
                        break;
                }
            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse(false, false, true);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initBus1(true);
                        break;
                    case 3:
                        initEvent1(true, true);
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

        startTime = "";
        endTime = "";
        leaveType = "";
        leavePeriod = "";
        leavePeriodMap = new ArrayList<>();

        final CaldroidFragment startDialogCaldroidFragment = CaldroidFragment.newInstance("選擇起始時間", (Calendar.getInstance().get(Calendar.MONTH)+1), Calendar.getInstance().get(Calendar.YEAR));
        final CaldroidFragment endDialogCaldroidFragment = CaldroidFragment.newInstance("選擇結束時間", (Calendar.getInstance().get(Calendar.MONTH)+1), Calendar.getInstance().get(Calendar.YEAR));
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        startDialogCaldroidFragment.setMinDate(Calendar.getInstance().getTime());
        endDialogCaldroidFragment.setMinDate(Calendar.getInstance().getTime());

        final TextView startTimeTextView = (TextView) findViewById(R.id.startTimeTextView);
        final CaldroidListener startListener = new CaldroidListener() {
            @Override
            public void onSelectDate(Date date, View view) {
                startTime = formatter.format(date);
                startTimeTextView.setText("起始時間 " + startTime.replace("/","-"));
                endDialogCaldroidFragment.setMinDate(date);
                startDialogCaldroidFragment.dismiss();
            }
            @Override
            public void onChangeMonth(int month, int year) {}
            @Override
            public void onLongClickDate(Date date, View view) {}
            @Override
            public void onCaldroidViewCreated() {
                startDialogCaldroidFragment.setEnableSwipe(true);
                startDialogCaldroidFragment.refreshView();
            }
        };
        startDialogCaldroidFragment.setCaldroidListener(startListener);

        final TextView endTimeTextView = (TextView) findViewById(R.id.endTimeTextView);
        final CaldroidListener endListener = new CaldroidListener() {
            @Override
            public void onSelectDate(Date date, View view) {
                endTime = formatter.format(date);
                endTimeTextView.setText("結束時間 " + endTime.replace("/","-"));
                endDialogCaldroidFragment.dismiss();
            }
            @Override
            public void onChangeMonth(int month, int year) {}
            @Override
            public void onLongClickDate(Date date, View view) {}
            @Override
            public void onCaldroidViewCreated() {
                endDialogCaldroidFragment.setEnableSwipe(true);
                endDialogCaldroidFragment.refreshView();
            }
        };
        endDialogCaldroidFragment.setCaldroidListener(endListener);

        RelativeLayout startTimePick = (RelativeLayout) findViewById(R.id.startTime);
        startTimePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDialogCaldroidFragment.show(getSupportFragmentManager(), "Caldroid");
            }
        });

        RelativeLayout endTimePick = (RelativeLayout) findViewById(R.id.endTime);
        endTimePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startTime.equals(""))
                {
                    AlertDialogPro.Builder builder = CustomDialog("", "請先選擇起始時間", false);
                    builder.setPositiveButton("確定", null).show();
                }
                else
                    endDialogCaldroidFragment.show(getSupportFragmentManager(), "Caldroid");
            }
        });

        RelativeLayout selectLeaveType = (RelativeLayout) findViewById(R.id.leaveType);
        final TextView leaveTypeText = (TextView) findViewById(R.id.leaveTypeTextView);
        selectLeaveType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] leave_type_list = new String[]{"事假", "病假", "公假", "喪假", "產假"};
                final String[] leave_type_map = new String[]{"21", "22", "23", "24", "26"};
                final ArrayList<String> map =  new ArrayList<>(Arrays.asList("21", "22", "23", "24", "26"));
                Integer selectItem;

                if (leaveType.equals(""))
                {
                    selectItem = 0;
                    leaveType = leave_type_map[0];
                    leaveTypeText.setText("請假類別 " + leave_type_list[0]);
                }
                else
                    selectItem = map.indexOf(leaveType);
                AlertDialogPro.Builder builder = CustomDialog("選擇請假類別", "", false);
                builder.setSingleChoiceItems(leave_type_list,
                                selectItem,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        leaveType = leave_type_map[which];
                                        leaveTypeText.setText("請假類別 " + leave_type_list[which]);
                                    }
                                })
                        .setPositiveButton("確定", null)
                        .show();
            }
        });

        RelativeLayout selectLeavePeriod = (RelativeLayout) findViewById(R.id.leavePeriod);
        final TextView leavePeriodText = (TextView) findViewById(R.id.leavePeriodTextView);
        selectLeavePeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] leave_period_list = new String[]{"M", "1", "2", "3", "4", "A", "5", "6", "7", "8", "B", "11", "12", "13", "14"};
                final String[] leave_period_map = new String[]{"A", "1", "2", "3", "4", "B", "5", "6", "7", "8", "C", "11", "12", "13", "14"};
                final ArrayList<String> list =  new ArrayList<>(Arrays.asList("M", "1", "2", "3", "4", "A", "5", "6", "7", "8", "B", "11", "12", "13", "14"));
                final ArrayList<String> map =  new ArrayList<>(Arrays.asList("A", "1", "2", "3", "4", "B", "5", "6", "7", "8", "C", "11", "12", "13", "14"));
                final ArrayList<String> leavePeriodList = new ArrayList<>();
                boolean[] selectedItems = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
                for (int i = 0; i < leavePeriodMap.size(); i ++)
                {
                    leavePeriodList.add(list.get(map.indexOf(leavePeriodMap.get(i))));
                    selectedItems[map.indexOf(leavePeriodMap.get(i))] = true;
                }
                AlertDialogPro.Builder builder = CustomDialog("選擇請假節次", "", false);
                builder.setMultiChoiceItems(leave_period_list,
                                selectedItems,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        if (isChecked) {
                                            leavePeriodMap.add(leave_period_map[which]);
                                            leavePeriodList.add(leave_period_list[which]);
                                        } else {
                                            leavePeriodMap.remove(leave_period_map[which]);
                                            leavePeriodList.remove(leave_period_list[which]);
                                        }
                                        String show = "";

                                        for (int i = 0; i < leavePeriodList.size(); i ++)
                                        {
                                            for (int j = i+1; j < leavePeriodList.size(); j ++)
                                            {
                                                if (list.indexOf(leavePeriodList.get(i)) > list.indexOf(leavePeriodList.get(j)))
                                                {
                                                    String tmp = leavePeriodList.get(i);
                                                    leavePeriodList.set(i, leavePeriodList.get(j));
                                                    leavePeriodList.set(j, tmp);
                                                }
                                            }
                                        }

                                        for (int i = 0; i < leavePeriodList.size(); i ++)
                                            show += "," + leavePeriodList.get(i);
                                        if (show.length() > 1)
                                            leavePeriodText.setText("請假節次 " + show.substring(1));
                                        else
                                            leavePeriodText.setText("選擇請假節次");
                                    }
                                })
                        .setPositiveButton("確定", null)
                        .show();
            }
        });

        LeaveSubmitRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (!CheckLoginState())
                    {
                        if (!ReLogin())
                        {
                            ReLoginHandler.sendEmptyMessage(-1);
                            return;
                        }
                    }

                    List<NameValuePair> params = new LinkedList<>();
                    // Server
                    params.add(new BasicNameValuePair("start_date", startTime));
                    params.add(new BasicNameValuePair("end_date", endTime));
                    params.add(new BasicNameValuePair("reason_id", leaveType));
                    params.add(new BasicNameValuePair("reason_text", leaveReason));
                    params.add(new BasicNameValuePair("section", leavePeriod));
                    Message msg = new Message();
                    msg.what = 1;
                    try {
                        JSONArray jsonObj = new JSONArray(post_url_contents(api_server + "leave/submit", params, cookieStore));
                        msg.obj = jsonObj.get(1).toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    LeaveSubmitHandler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        final EditText leaveReasonEditText = (EditText) findViewById(R.id.leaveReasonEditText);
        RelativeLayout leaveSend = (RelativeLayout) findViewById(R.id.leaveSend);
        leaveSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList<String> leave_period_list =  new ArrayList<>(Arrays.asList("M", "1", "2", "3", "4", "A", "5", "6", "7", "8", "B", "11", "12", "13", "14"));
                final ArrayList<String> leave_period_map =  new ArrayList<>(Arrays.asList("A", "1", "2", "3", "4", "B", "5", "6", "7", "8", "C", "11", "12", "13", "14"));
                String leavePeriodx = "";

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Integer Days = 0;
                try{
                    Calendar c1 = Calendar.getInstance();
                    Calendar c2 = Calendar.getInstance();
                    Date dt1 = sdf.parse(startTime);
                    Date dt2 =sdf.parse(endTime);
                    c1.setTime(dt1);
                    c2.setTime(dt2);
                    Days =  c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < leavePeriodMap.size(); i ++)
                {
                    for (int j = i+1; j < leavePeriodMap.size(); j ++)
                    {
                        if (leave_period_map.indexOf(leavePeriodMap.get(i)) > leave_period_map.indexOf(leavePeriodMap.get(j)))
                        {
                            String tmp = leavePeriodMap.get(i);
                            leavePeriodMap.set(i, leavePeriodMap.get(j));
                            leavePeriodMap.set(j, tmp);
                        }
                    }
                }
                JSONArray jsonObj =new JSONArray();
                for (int i = 0; i < leavePeriodMap.size(); i ++)
                    leavePeriodx += "," + leave_period_list.get(leave_period_map.indexOf(leavePeriodMap.get(i)));

                for (int j = 0; j <= Days; j++)
                {
                    for (int i = 0; i < leavePeriodMap.size(); i ++)
                    {
                        jsonObj.put(Integer.toString(leave_period_map.indexOf(leavePeriodMap.get(i)) + j * 15));
                    }
                }
                final String leavePeriodxx = leavePeriodx;
                if (!jsonObj.toString().equals("[]"))
                    leavePeriod = jsonObj.toString();
                else
                    leavePeriod = "";
                leaveReason = leaveReasonEditText.getText().toString();
                if (startTime.equals("") ||
                        endTime.equals("") ||
                        leaveType.equals("") ||
                        leaveReasonEditText.getText().toString().equals("") ||
                        leavePeriod.equals(""))
                {
                    AlertDialogPro.Builder builder = CustomDialog("", "尚有項目未選擇或填寫", false);
                    builder.setPositiveButton("確定", null).show();
                }
                else
                {
                    final String[] leave_type_list = new String[]{"事假", "病假", "公假", "喪假", "產假"};
                    final ArrayList<String> leave_type_map =  new ArrayList<>(Arrays.asList("21", "22", "23", "24", "26"));
                    final AlertDialogPro.Builder builder = CustomDialog("請假登錄測試中", "注意！本功能將送出假單, 請在送出前再次確認您的請假節次，請務必特別留意。\n\n" +
                            "如要查詢單號，請上網頁版查詢。\n\n" +
                            "其餘請假規定，請自行查閱。", false);
                    builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    final AlertDialogPro.Builder builderx = CustomDialog("確認請假資訊", "起始時間：" + startTime +
                                            "\n結束時間：" + endTime +
                                            "\n請假類別：" + leave_type_list[leave_type_map.indexOf(leaveType)] +
                                            "\n請假事由：" + leaveReasonEditText.getText() +
                                            "\n請假節次：" + leavePeriodxx.substring(1), false);
                                    builderx.setPositiveButton("確認送出", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    LeaveSubmitHandler.sendEmptyMessage(-1);
                                                    new Thread(LeaveSubmitRunnable).start();
                                                }
                                            }).
                                            setNegativeButton("返回修改", null).show();
                                }
                            }).
                            setNegativeButton("算了返回", null).show();
                }
            }
        });
    }

    public void initEvent1(final boolean _isLogin, boolean ReLoad){
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
        final String[] values;
        if (_isLogin)
            values = new String[]{ "學期課表", "學期成績", "缺曠系統", "校車系統" };
        else
            values = new String[]{ "離線課表" };
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
        mAboutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initAbout(_isLogin);
                        break;
                }
            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        if (_isLogin)
                            initCourse(false, false, true);
                        else
                            initCourse(false, false, false);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initLeave1(false, false);
                        break;
                    case 3:
                        initBus1(true);
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

        ReadNotificationRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    NotificationList.clear();
                    // Server
                    try {
                        JSONArray jsonObj = new JSONArray(get_url_contents(api_server + "notification/" + NotificationPage, null, cookieStore));
                        for (int i = 0; i < jsonObj.length(); i ++)
                        {
                            NotificationList.add(new NotificationList(jsonObj.getJSONObject(i).getJSONArray("info").get(1).toString(),
                                    jsonObj.getJSONObject(i).getJSONArray("info").get(2).toString(),
                                    jsonObj.getJSONObject(i).getJSONArray("info").get(0).toString(),
                                    jsonObj.getJSONObject(i).getString("link")));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ReadNotificationHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        final TextView PageUpTextView = (TextView) findViewById(R.id.PageUpTextView);
        final TextView NowPage = (TextView) findViewById(R.id.NowPageTextView);
        RelativeLayout PageUp = (RelativeLayout) findViewById(R.id.PageUp);
        PageUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NotificationPage > 1)
                {
                    NotificationPage --;
                    NowPage.setText("第" + NotificationPage + "頁");
                    ReadNotificationHandler.sendEmptyMessage(-1);
                    new Thread(ReadNotificationRunnable).start();
                }
                if (NotificationPage == 1)
                    PageUpTextView.setTextColor(getResources().getColor(R.color.bar_grey));
                else
                    PageUpTextView.setTextColor(Color.BLACK);
            }
        });

        RelativeLayout PageDown = (RelativeLayout) findViewById(R.id.PageDown);
        PageDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationPage ++;
                NowPage.setText("第" + NotificationPage + "頁");
                ReadNotificationHandler.sendEmptyMessage(-1);
                new Thread(ReadNotificationRunnable).start();
                if (NotificationPage == 1)
                    PageUpTextView.setTextColor(getResources().getColor(R.color.bar_grey));
                else
                    PageUpTextView.setTextColor(Color.BLACK);
            }
        });

        if (ReLoad)
        {
            NotificationPage = 1;
            ReadNotificationHandler.sendEmptyMessage(-1);
            new Thread(ReadNotificationRunnable).start();
        }
        else
        {
            NowPage.setText("第" + NotificationPage + "頁");
            addNotification();
        }

        if (NotificationPage == 1)
            PageUpTextView.setTextColor(getResources().getColor(R.color.bar_grey));
        else
            PageUpTextView.setTextColor(Color.BLACK);
    }

    public void initEvent2(final boolean _isLogin){
        setContentView(R.layout.event2);

        RelativeLayout Page1 = (RelativeLayout) findViewById(R.id.RelativeLayout);
        Page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEvent1(_isLogin, false);
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
        final String[] values;
        if (_isLogin)
            values = new String[]{ "學期課表", "學期成績", "缺曠系統", "校車系統" };
        else
            values = new String[]{ "離線課表" };
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
        mAboutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initAbout(_isLogin);
                        break;
                }
            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        if (_isLogin)
                            initCourse(false, false, true);
                        else
                            initCourse(false, false, false);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initLeave1(false, false);
                        break;
                    case 3:
                        initBus1(true);
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
        addPhone();
    }

    public void initEvent3(final boolean _isLogin){
        setContentView(R.layout.event3);

        RelativeLayout Page1 = (RelativeLayout) findViewById(R.id.RelativeLayout);
        Page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEvent1(_isLogin, false);
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
        final String[] values;
        if (_isLogin)
            values = new String[]{ "學期課表", "學期成績", "缺曠系統", "校車系統" };
        else
            values = new String[]{ "離線課表" };
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
        mAboutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initAbout(_isLogin);
                        break;
                }
            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        if (_isLogin)
                            initCourse(false, false, true);
                        else
                            initCourse(false, false, false);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initLeave1(false, false);
                        break;
                    case 3:
                        initBus1(true);
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
        addSchedule();
    }

    private void initBus1(boolean ShowCal)
    {
        setContentView(R.layout.bus1);

        RelativeLayout Page2 = (RelativeLayout) findViewById(R.id.RelativeLayout2);
        Page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initBus2();
            }
        });

        final RelativeLayout location1 = (RelativeLayout) findViewById(R.id.location1);
        final RelativeLayout location2 = (RelativeLayout) findViewById(R.id.location2);
        location1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!BusEndStation.equals("燕巢"))
                {
                    location1.setBackgroundColor(getResources().getColor(R.color.blue_2));
                    location2.setBackgroundColor(getResources().getColor(R.color.bar_grey));
                    BusEndStation = "燕巢";
                    addBus();
                }
            }
        });
        location2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!BusEndStation.equals("建工"))
                {
                    location1.setBackgroundColor(getResources().getColor(R.color.bar_grey));
                    location2.setBackgroundColor(getResources().getColor(R.color.green));
                    BusEndStation = "建工";
                    addBus();
                }
            }
        });

        TextView noBusTextView = (TextView) findViewById(R.id.noBusTextView);
        noBusTextView.setVisibility(View.GONE);

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
        final String[] values = new String[]{ "學期課表", "學期成績", "缺曠系統", "校園資訊" };
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
        mAboutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initAbout(true);
                        break;
                }
            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse(false, false, true);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initLeave1(false, false);
                        break;
                    case 3:
                        initEvent1(true, true);
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

        final CaldroidFragment dialogCaldroidFragment = CaldroidFragment.newInstance("選擇乘車時間", (Calendar.getInstance().get(Calendar.MONTH)+1), Calendar.getInstance().get(Calendar.YEAR));
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        dialogCaldroidFragment.setMinDate(Calendar.getInstance().getTime());
        dialogCaldroidFragment.refreshView();

        final TextView timeTextView = (TextView) findViewById(R.id.timeTextView);
        final CaldroidListener listener = new CaldroidListener() {
            @Override
            public void onSelectDate(Date date, View view) {
                BusDate = formatter.format(date);
                timeTextView.setText("乘車時間 " + BusDate);
                ReadBusHandler.sendEmptyMessage(-1);
                new Thread(ReadBusRunnable).start();
                dialogCaldroidFragment.dismiss();
            }
            @Override
            public void onChangeMonth(int month, int year) {}
            @Override
            public void onLongClickDate(Date date, View view) {}
            @Override
            public void onCaldroidViewCreated() {
                dialogCaldroidFragment.setEnableSwipe(true);
                //dialogCaldroidFragment.setCancelable(false);
                dialogCaldroidFragment.refreshView();
            }
        };
        dialogCaldroidFragment.setCaldroidListener(listener);

        RelativeLayout timePick = (RelativeLayout) findViewById(R.id.time);
        timePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCaldroidFragment.show(getSupportFragmentManager(), "Caldroid");
            }
        });

        BusBookingRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (!CheckLoginState())
                    {
                        if (!ReLogin())
                        {
                            ReLoginHandler.sendEmptyMessage(-1);
                            return;
                        }
                    }

                    // Server
                    List<NameValuePair> params = new LinkedList<>();
                    params.add(new BasicNameValuePair("busId", _busId));
                    params.add(new BasicNameValuePair("action", _busAction));
                    try {
                        JSONArray jsonObj = new JSONArray("[" + post_url_contents(api_server + "bus/booking", params, cookieStore) + "]");
                        Message msg = new Message();
                        msg.what = 3;
                        msg.obj = jsonObj.get(0).toString();
                        ReadBusHandler.sendMessage(msg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        ReadBusRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (!CheckLoginState())
                    {
                        if (!ReLogin())
                        {
                            ReLoginHandler.sendEmptyMessage(-1);
                            return;
                        }
                    }

                    // Server
                    List<NameValuePair> params = new LinkedList<>();
                    params.add(new BasicNameValuePair("date", BusDate));
                    System.out.println(get_url_contents(api_server + "bus/reserve", null, cookieStore));
                    BusList.clear();
                    try {
                        JSONArray jsonObj = new JSONArray(post_url_contents(api_server + "bus/query", params, cookieStore));
                        for (int i = 0; i < jsonObj.length(); i++) {
                            JSONObject item = jsonObj.getJSONObject(i);
                            BusList.add(new BusList(item.getString("busId"),
                                    item.getString("endStation"),
                                    item.getInt("reserveCount"),
                                    item.getInt("limitCount"),
                                    item.getString("runDateTime"),
                                    item.getInt("isReserve")));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ReadBusHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        if (ShowCal)
            dialogCaldroidFragment.show(getSupportFragmentManager(), "Caldroid");
        else
        {
            timeTextView.setText("乘車時間 " + BusDate);
            ReadBusHandler.sendEmptyMessage(-1);
            new Thread(ReadBusRunnable).start();
        }
    }

    private void initBus2()
    {
        setContentView(R.layout.bus2);

        TextView noReserveTextView = (TextView) findViewById(R.id.noReserveTextView);
        ImageView noReserveImageView = (ImageView) findViewById(R.id.noReserveImageView);
        noReserveTextView.setVisibility(View.GONE);
        noReserveImageView.setVisibility(View.GONE);

        RelativeLayout Page1 = (RelativeLayout) findViewById(R.id.relativeLayout);
        Page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initBus1(false);
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
        final String[] values = new String[]{ "學期課表", "學期成績", "缺曠系統", "校園資訊" };
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
        mAboutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initAbout(true);
                        break;
                }
            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        initCourse(false, false, true);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initLeave1(false, false);
                        break;
                    case 3:
                        initEvent1(true, true);
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

        BusBookingRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (!CheckLoginState())
                    {
                        if (!ReLogin())
                        {
                            ReLoginHandler.sendEmptyMessage(-1);
                            return;
                        }
                    }

                    // Server
                    List<NameValuePair> params = new LinkedList<>();
                    params.add(new BasicNameValuePair("busId", _busId));
                    params.add(new BasicNameValuePair("action", _busAction));
                    try {
                        JSONArray jsonObj = new JSONArray("[" + post_url_contents(api_server + "bus/booking", params, cookieStore) + "]");
                        Message msg = new Message();
                        msg.what = 4;
                        msg.obj = jsonObj.get(0).toString();
                        ReadBusHandler.sendMessage(msg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        BusReserveRunnable = new Runnable() {
            @Override
            public void run() {
            try {
                if (!CheckLoginState())
                {
                    if (!ReLogin())
                    {
                        ReLoginHandler.sendEmptyMessage(-1);
                        return;
                    }
                }

                // Server
                BusReserveList.clear();
                try {
                    JSONArray jsonObj = new JSONArray(get_url_contents(api_server + "bus/reserve", null, cookieStore));
                    for (int i = 0; i < jsonObj.length(); i++) {
                        JSONObject item = jsonObj.getJSONObject(i);
                        BusReserveList.add(new BusList(item.getString("key"),
                                item.getString("end"),
                                0,
                                0,
                                item.getString("time"),
                                1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ReadBusHandler.sendEmptyMessage(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
        };

        ReadBusHandler.sendEmptyMessage(-1);
        new Thread(BusReserveRunnable).start();
    }

    private void initAbout(final boolean _isLogin)
    {
        setContentView(R.layout.about);

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
        final String[] values;
        if (_isLogin)
            values = new String[]{ "學期課表", "學期成績", "缺曠系統", "校車系統", "校園資訊" };
        else
            values = new String[]{ "校園資訊" };
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
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        if (_isLogin)
                            initCourse(false, false, true);
                        else
                            initEvent1(_isLogin, true);
                        break;
                    case 1:
                        initScore(false, false);
                        break;
                    case 2:
                        initLeave1(false, false);
                        break;
                    case 3:
                        initEvent1(true, true);
                        break;
                    case 4:
                        initEvent1(_isLogin, true);
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

        ImageView facebook = (ImageView) findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pages/%E9%AB%98%E6%87%89%E6%A0%A1%E5%8B%99%E9%80%9A/954175941266264?fref=ts"));
                startActivity(browserIntent);
            }
        });
        ImageView github = (ImageView) findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/kuastw"));
                startActivity(browserIntent);
            }
        });
        ImageView mail = (ImageView) findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:1102108133@kuas.edu.tw"));
                startActivity(browserIntent);
            }
        });

        _fncid = "";
    }

    private Handler ReadScoreHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
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
        public void handleMessage(Message msg) {
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
        public void handleMessage(Message msg) {
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

    private Handler LeaveSubmitHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
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
                    AlertDialogPro.Builder builder = CustomDialog("假單送出結果",(String) msg.obj, false);
                    builder.setPositiveButton("OK", null).show();
                    LoadingDialog.dismiss();
                    break;
            }
        };
    };

    private Handler ReadSemesterHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
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

    private Handler ReadBusHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
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
                    addBus();
                    LoadingDialog.dismiss();
                    break;
                case 2:
                    addReserveBus();
                    LoadingDialog.dismiss();
                    break;
                case 3:
                    Toast.makeText(getApplicationContext(), (String) msg.obj, Toast.LENGTH_SHORT).show();
                    ReadBusHandler.sendEmptyMessage(-1);
                    new Thread(ReadBusRunnable).start();
                    break;
                case 4:
                    Toast.makeText(getApplicationContext(), (String) msg.obj, Toast.LENGTH_SHORT).show();
                    ReadBusHandler.sendEmptyMessage(-1);
                    new Thread(BusReserveRunnable).start();
                    break;
            }
        };
    };

    private Handler ReadNotificationHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
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
                    addNotification();
                    LoadingDialog.dismiss();
                    break;
            }
        };
    };

    private Handler LoginHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
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
                    AlertDialogPro.Builder builder = CustomDialog("Error", "帳號或密碼輸入錯誤 !", false);
                    builder.setPositiveButton("確定", null).show();
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

    private Handler ReLoginHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what)
            {
                case -1:
                    LoadingDialog.dismiss();
                    initReLogin();
                    break;
            }
        };
    };

    private Handler CheckServerStatusHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what)
            {
                case 1:
                    initServerStatus();
                    break;
            }
        };
    };

    public Bitmap getBitmapFromURL(String src) {
        try {
            java.net.URL url = new java.net.URL(src);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void showNews(){
        try {
            JSONArray jsonObj = new JSONArray(get_url_contents(api_server + "news/status", null, cookieStore));
            if ((jsonObj.getInt(0) == 1 && jsonObj.getInt(1) > news_id) || NewsDebug)
            {
                news_id = jsonObj.getInt(1);
                SharedPreferences setting = getSharedPreferences("KUAS AP", 0);
                setting.edit().putInt("news_id", news_id).apply();
                jsonObj = new JSONArray(get_url_contents(api_server + "news", null, cookieStore));
                WebView image = new WebView(MainActivity.this);
                image.setBackgroundColor(0);
                image.loadDataWithBaseURL("", jsonObj.getString(3),"text/html", "UTF-8", "");
                AlertDialogPro.Builder builder;
                final String Url = jsonObj.getString(4);
                if (!Url.equals(""))
                {
                    builder = CustomDialog(jsonObj.getString(2), "", true);
                    builder.setView(image).
                            setPositiveButton("立即前往", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Url));
                                    startActivity(browserIntent);
                                }
                            }).
                            setNegativeButton("朕知道了", null).setCancelable(false).show();
                }
                else
                {
                    builder = CustomDialog(jsonObj.getString(2), "", true);
                    builder.setView(image).
                            setPositiveButton("朕知道了", null)
                            .setCancelable(false).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPhone() {
        PhoneListAdapter adapter = new PhoneListAdapter(MainActivity.this);
        PhoneList.clear();
        PhoneList.add(new PhoneList("高雄應用科技大學總機", "(07) 381-4526"));
        PhoneList.add(new PhoneList("建工校安專線", "0916-507-506"));
        PhoneList.add(new PhoneList( "燕巢校安專線", "0925-350-995"));
        PhoneList.add(new PhoneList("事務組", "(07) 381-4526 #2650"));
        PhoneList.add(new PhoneList("營繕組", "(07) 381-4526 #2630"));
        PhoneList.add(new PhoneList("課外活動組", "(07) 381-4526 #2525"));
        PhoneList.add(new PhoneList("諮商輔導中心", "(07) 381-4526 #2541"));
        PhoneList.add(new PhoneList("圖書館", "(07) 381-4526 #3100"));
        PhoneList.add(new PhoneList("建工校外賃居服務中心", "(07) 381-4526 #3420"));
        PhoneList.add(new PhoneList("燕巢校外賃居服務中心", "(07) 381-4526 #8615"));
        adapter.setData(PhoneList);
        ListView PhoneListView = (ListView) findViewById(R.id.phone_listView);
        PhoneListView.setAdapter(adapter);

        PhoneListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialogPro.Builder builder = CustomDialog("撥出電話", "確定要撥給「" + PhoneList.get(position).title + "」？", false);
                builder.setPositiveButton("撥出", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent myIntentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ PhoneList.get(position).number.replace("#", ",")));
                                startActivity(myIntentDial);
                            }
                        }).
                        setNegativeButton("返回", null).setCancelable(false).show();
            }
        });
    }

    public void addSchedule(){
        TableLayout table = (TableLayout) findViewById(R.id.tablelayout);
        table.setStretchAllColumns(true);
        table.setShrinkAllColumns(true);
        table.removeAllViews();
        try {
            JSONArray jsonObj = new JSONArray(scheduleData);
            for (int i = 0; i < jsonObj.length(); i++) {
                TableRow row = (TableRow)LayoutInflater.from(MainActivity.this).inflate(R.layout.schedule_item, null);
                JSONObject item = jsonObj.getJSONObject(i);
                ((TextView)row.findViewById(R.id.title)).setText(item.getString("week"));
                ((TextView)row.findViewById(R.id.title)).setTextColor(Color.BLACK);
                row.findViewById(R.id.RelativeLayout).setBackgroundColor(getResources().getColor(R.color.background_grey));
                table.addView(row);
                for (int j = 0; j < item.getJSONArray("events").length(); j++)
                {
                    TableRow rowx = (TableRow)LayoutInflater.from(MainActivity.this).inflate(R.layout.schedule_item, null);
                    ((TextView)rowx.findViewById(R.id.title)).setText(item.getJSONArray("events").get(j).toString());
                    table.addView(rowx);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNotification() {
        NotificationListAdapter adapter = new NotificationListAdapter(MainActivity.this);
        adapter.setData(NotificationList);
        ListView NotificationListView = (ListView) findViewById(R.id.notification_listView);
        NotificationListView.setAdapter(adapter);

        NotificationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(NotificationList.get(position).link));
                startActivity(browserIntent);
            }
        });
    }

    public void addBus() {
        TextView noBusTextView = (TextView) findViewById(R.id.noBusTextView);

        final ArrayList<BusList> NewBusList = new ArrayList<>();
        for (int i = 0; i < BusList.size(); i ++)
            if (BusList.get(i).endStation.equals(BusEndStation))
                NewBusList.add(BusList.get(i));

        TableLayout table = (TableLayout) findViewById(R.id.tablelayout);
        table.setStretchAllColumns(true);
        table.removeAllViews();

        if (BusList.size() == 0)
        {
            noBusTextView.setVisibility(View.VISIBLE);
            return;
        }
        else
        {
            noBusTextView.setVisibility(View.GONE);
        }

        for (int i = 0; i < NewBusList.size(); i++)
        {
            final String Station;
            if (NewBusList.get(i).endStation.equals("燕巢"))
                Station = "建工到燕巢";
            else
                Station = "燕巢到建工";
            final String time =  NewBusList.get(i).runDateTime.split(" ")[1];
            final String busId = NewBusList.get(i).busId;
            final String runDate = NewBusList.get(i).runDateTime;
            TableRow row = (TableRow)LayoutInflater.from(MainActivity.this).inflate(R.layout.bus_item, null);
            if (NewBusList.get(i).isReserve == -1)
            {
                if (NewBusList.get(i).endStation.equals("燕巢"))
                    row.findViewById(R.id.RelativeLayout).setBackgroundColor(getResources().getColor(R.color.blue_2));
                else
                    row.findViewById(R.id.RelativeLayout).setBackgroundColor(getResources().getColor(R.color.green));
                row.findViewById(R.id.RelativeLayout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialogPro.Builder builder = CustomDialog("確定要 預定 本校車車次？", "要預定從" + Station + time + "的校車嗎？", false);
                        builder.setPositiveButton("預定校車", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        _busId = busId;
                                        _busAction = "";
                                        new Thread(BusBookingRunnable).start();
                                    }
                                }).
                                setNegativeButton("返回", null).setCancelable(false).show();
                    }
                });
                ((TextView)row.findViewById(R.id.location)).setText("到" + NewBusList.get(i).endStation + "，發車：");
            }
            else
            {
                row.findViewById(R.id.RelativeLayout).setBackgroundColor(getResources().getColor(R.color.red));
                row.findViewById(R.id.RelativeLayout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialogPro.Builder builder = CustomDialog("確定要 取消 本校車車次？", "要取消從" + Station + time + "的校車嗎？", false);
                        builder.setPositiveButton("取消校車", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        _busId = runDate;
                                        _busAction = "un";
                                        new Thread(BusBookingRunnable).start();
                                    }
                                }).
                                setNegativeButton("返回", null).setCancelable(false).show();
                    }
                });
                ((TextView)row.findViewById(R.id.location)).setText("✔ 到" + NewBusList.get(i).endStation + "，發車：");
            }
            ((TextView)row.findViewById(R.id.time)).setText(NewBusList.get(i).runDateTime.split(" ")[1]);
            ((TextView)row.findViewById(R.id.count)).setText("(" + NewBusList.get(i).reserveCount + "/" + NewBusList.get(i).limitCount + ")");
            table.addView(row);
        }
    }

    public void addReserveBus() {
        TableLayout table = (TableLayout) findViewById(R.id.tablelayout);
        table.setStretchAllColumns(true);
        table.removeAllViews();
        TextView noReserveTextView = (TextView) findViewById(R.id.noReserveTextView);
        ImageView noReserveImageView = (ImageView) findViewById(R.id.noReserveImageView);

        if (BusReserveList.size() != 0)
        {
            noReserveTextView.setVisibility(View.GONE);
            noReserveImageView.setVisibility(View.GONE);
        }
        else
        {
            noReserveTextView.setVisibility(View.VISIBLE);
            noReserveImageView.setVisibility(View.VISIBLE);
        }

        for (int i = 0; i < BusReserveList.size(); i++)
        {
            final String Station;
            if (BusReserveList.get(i).endStation.equals("燕巢"))
                Station = "建工到燕巢";
            else
                Station = "燕巢到建工";
            final String time =  BusReserveList.get(i).runDateTime.split(" ")[1];
            final String runDate = BusReserveList.get(i).runDateTime;
            TableRow row = (TableRow)LayoutInflater.from(MainActivity.this).inflate(R.layout.busreserve_item, null);

            if (BusReserveList.get(i).endStation.equals("燕巢"))
                row.findViewById(R.id.relativelayout).setBackgroundColor(getResources().getColor(R.color.blue_2));
            else
                row.findViewById(R.id.relativelayout).setBackgroundColor(getResources().getColor(R.color.green));


            row.findViewById(R.id.relativelayout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialogPro.Builder builder = CustomDialog("確定要 取消 本校車車次？", "要取消從" + Station + time + "的校車嗎？", false);
                    builder.setPositiveButton("取消校車", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    _busId = runDate;
                                    _busAction = "un";
                                    new Thread(BusBookingRunnable).start();
                                }
                            }).
                            setNegativeButton("返回", null).setCancelable(false).show();
                }
            });
            ((TextView)row.findViewById(R.id.location)).setText("到" + BusReserveList.get(i).endStation + "，發車日期：");
            ((TextView)row.findViewById(R.id.date)).setText(BusReserveList.get(i).runDateTime.split(" ")[0]);
            ((TextView)row.findViewById(R.id.time)).setText(BusReserveList.get(i).runDateTime.split(" ")[1]);
            table.addView(row);
        }
    }

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
            if (isNightLeave)
                titles = new String[]{"日期", "M", "1", "2", "3", "4", "A", "5", "6", "7", "8", "B", "11", "12", "13", "14"};
            else
                titles = new String[]{"日期", "M", "1", "2", "3", "4", "A", "5", "6", "7", "8"};
        }
        else //垂直
        {
            if (isNightLeave)
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

    public void addOfflineCourse() {
        //TableLayout table = (TableLayout) findViewById(R.id.tablelayout);
        //table.setStretchAllColumns(true);
        //table.removeAllViews();
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.removeAllViews();

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);

        isHolidayClass = false;
        isHolidayNightClass = false;
        isNightClass = false;
        CourseList = new ArrayList<>();

        SharedPreferences setting = getSharedPreferences("KUAS AP", 0);
        OfflineCourseData = setting.getString("OfflineCourse", "");

        TextView noOfflineCoureTextView = (TextView) findViewById(R.id.noOfflineCourseTextView);
        RelativeLayout OfflineCourse = (RelativeLayout) findViewById(R.id.OfflineCourse);
        if (OfflineCourseData.equals(""))
        {
            noOfflineCoureTextView.setVisibility(View.VISIBLE);
            OfflineCourse.setVisibility(View.GONE);
            return;
        }
        else
        {
            noOfflineCoureTextView.setVisibility(View.GONE);
        }

        try {
            JSONArray jsonObj = new JSONArray(OfflineCourseData);
            for (int i = 0; i < jsonObj.getJSONObject(0).length(); i++) {
                JSONObject item = jsonObj.getJSONObject(0).getJSONObject(Integer.toString(i));
                ArrayList<CourseList> CourseList2 = new ArrayList<>();
                for (int j = 1; j < 8; j ++)
                {
                    JSONObject itemdata = item.getJSONObject(Integer.toString(j));
                    if (j >= 6 && !itemdata.getString("course_name").equals(""))
                    {
                        isHolidayClass = true;
                        if (i >= 10)
                            isHolidayNightClass = true;
                    }
                    else if (!itemdata.getString("course_name").equals("") && i >= 10)
                        isNightClass = true;

                    CourseList2.add(new CourseList(itemdata.getString("course_name"),
                            itemdata.getString("course_teacher"),
                            itemdata.getString("course_classroom"),
                            item.getString("time")));
                }
                CourseList.add(CourseList2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        addCourse();
    }

    public void addCourse() {
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.removeAllViews();
        TableLayout table;
        int x, y;

        TextView textView = (TextView) findViewById(R.id.textView);
        if (!isHolidayClass)
            textView.setVisibility(View.GONE);
        else
            textView.setVisibility(View.VISIBLE);

        if (getResources().getConfiguration().orientation == 2) //橫向
        {
            textView.setVisibility(View.GONE);
            if (isHolidayClass)
            {
                if (isNightClass || isHolidayNightClass)
                    table = (TableLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.course_tablelayout_holiday_night, null);
                else
                    table = (TableLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.course_tablelayout_holiday, null);

                if (isNightClass || isHolidayNightClass)
                    y = CourseList.size();
                else
                    y = 10;
                x = 7;
            }
            else
            {
                if (isNightClass)
                    table = (TableLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.course_tablelayout_normal_night, null);
                else
                    table = (TableLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.course_tablelayout_normal, null);

                if (isNightClass)
                    y = CourseList.size();
                else
                    y = 10;
                x = 5;
            }
        }
        else
        {
            if (isNightClass)
                table = (TableLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.course_tablelayout_normal_night, null);
            else
                table = (TableLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.course_tablelayout_normal, null);

            if (isNightClass)
                y = CourseList.size();
            else
                y = 10;
            x = 5;
        }

        table.setStretchAllColumns(true);

        if (CourseList.size() == 0)
        {
            table = (TableLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.course_tablelayout_nocourse, null);
            scrollView.addView(table);
            return;
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int id = getResources().getIdentifier("textView" +  i + "_" + (j+1), "id", getPackageName());
                final TextView testview = (TextView) table.findViewById(id);

                if (CourseList.get(i).get(j).ID.length() > 0)
                    testview.setText(CourseList.get(i).get(j).ID.substring(0,2));
                else
                    testview.setText("　　");

                final int yy = i;
                final int xx = j;
                if (!CourseList.get(i).get(j).ID.equals(""))
                    testview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialogPro.Builder builder = CustomDialog("" , "\n課程名稱：" + CourseList.get(yy).get(xx).ID
                                    + "\n授課老師：" +  CourseList.get(yy).get(xx).Teacher
                                    + "\n教室位置：" + CourseList.get(yy).get(xx).Place
                                    + "\n上課時間：" + CourseList.get(yy).get(xx).Time + "\n", false);
                            builder.setPositiveButton("確定", null).show();
                        }
                    });
            }
        }

        scrollView.addView(table);
    }

    public void addCourseOld() {
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
                            AlertDialogPro.Builder builder = CustomDialog("", "課程名稱：" + CourseList.get(yy).get(xx - 1).ID
                                    + "\n授課老師：" +  CourseList.get(yy).get(xx - 1).Teacher
                                    + "\n教室位置：" + CourseList.get(yy).get(xx - 1).Place
                                    + "\n上課時間：" + CourseList.get(yy).get(xx - 1).Time, false);
                            builder.setPositiveButton("確定", null).show();
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
        byte []data = new byte[102400];
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
        news_id = setting.getInt("news_id", -1);
        UserNameEditText.setText(username);
        PasswordEditText.setText(password);
        RememberPass.setChecked(remember);
    }
    private void savePrefs() {
        SharedPreferences setting = getSharedPreferences("KUAS AP", 0);
        setting.edit().putString("User", UserNameEditText.getText().toString()).apply();
        setting.edit().putInt("news_id", news_id).apply();
        if (RememberPass.isChecked())
            setting.edit().putString("Pwd", PasswordEditText.getText().toString()).apply();
        else
            setting.edit().putString("Pwd", "").apply();
        setting.edit().putBoolean("Remember", RememberPass.isChecked()).apply();

    }

    public AlertDialogPro.Builder CustomDialog(String Title, String Message, boolean _HighLight)
    {
        AlertDialogPro.Builder builder = new AlertDialogPro.Builder(MainActivity.this);
        TextView dialogTitle = new TextView(MainActivity.this);
        dialogTitle.setText(Title);
        dialogTitle.setPadding(0, 20, 0, 20);
        if (_HighLight)
        {
            dialogTitle.setTextColor(getResources().getColor(R.color.blue));
            dialogTitle.setTextSize(20);
        }
        else
        {
            dialogTitle.setTextColor(Color.BLACK);
            dialogTitle.setTextSize(18);
        }
        dialogTitle.setGravity(CENTER);

        TextView dialogMessage = new TextView(MainActivity.this);
        dialogMessage.setGravity(CENTER);
        dialogMessage.setTextColor(getResources().getColor(R.color.dialog_grey));
        dialogMessage.setTextSize(16);
        dialogMessage.setText(Message);
        if (Title.equals(""))
            dialogMessage.setPadding(40, 40, 40, 0);
        else
            dialogMessage.setPadding(40, 0, 40, 0);

        if (Title.equals(""))
            builder.setView(dialogMessage);
        else if (Message.equals(""))
            builder.setCustomTitle(dialogTitle);
        else
            builder.setCustomTitle(dialogTitle).
                    setView(dialogMessage);

        return builder;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) { }
        else { }
        if (_fncid.equals("AG222") && !LoadingDialog.isShowing() && !isSelecting)
        {
            if (isOfflineCourse)
                addOfflineCourse();
            else
                addCourse();
        }
        else if (_fncid.equals("AK002") && !LoadingDialog.isShowing() && !isSelecting)
            addLeave();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
