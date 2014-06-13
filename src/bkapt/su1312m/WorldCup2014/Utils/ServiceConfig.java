package bkapt.su1312m.WorldCup2014.Utils;


public interface ServiceConfig {

	public final static int TIME_OUT = 15000;
	public final static int TIME_OUT_POST = 100000;
	public final static int SUCCESS = 1;
	public final static String TOKEN = "token";

	public final static String ROOT = "http://49.212.199.178/dev_graduation/api/";
	public final static String IMAGE_ROOT = "http://49.212.199.178/dev_graduation/img/";

	public final static String HELP = ROOT + "information";
	public final static String LIST_CITY = ROOT + "list_city";
	public final static String LIST_DISTRICT = ROOT + "list_distric";
	public final static String UPDATE_SCHOOL = ROOT + "update_school";
	public final static String GET_LIST_SCHOOL = ROOT + "list_school";
	public final static String LIST_NEWEST_ALBUM = ROOT + "list_new_album";
	public final static String REGISTER = ROOT + "register";
	public final static String MYALBUM = ROOT + "my_album";
	public final static String LISTLEVEL = ROOT + "list_level";
	public final static String CREATE_ALBUM = ROOT + "create_album";
	public final static String UPLOAD_FILE = ROOT + "upload_file";
	public final static String SEARCH = ROOT + "search";
	public final static String ALBUM_DETAIL = ROOT + "list_album_detail";
	public final static String REMOVE_IMAGE = ROOT + "delete_file";
	public final static String ADD_IMAGE = ROOT + "insert_file";
	public final static String BUY_POINT = ROOT + "payment";
	

	public final static String WEB_URL_HELP = ROOT + "information?type=1";
	public final static String WEB_URL_PRIVATE = ROOT + "information?type=2";
	public final static String WEB_URL_ARTICLE = ROOT + "information?type=3";
	public final static String WEB_URL_INFO = ROOT + "information?type=4";
	public final static String WEB_URL_CONTACT = ROOT + "information?type=5";
	public final static String SHARE_CONTENT = ROOT + "share";
	public final static String CREATE_PASS = ROOT + "update_pass";
	public final static String CHANGE_DEVICE = ROOT + "change_device";
	public final static String CHECK_ALBUM = ROOT + "check_album";
	public final static String BUY_ALBUM = ROOT + "buy_album";

	public final static String SCHOOL_ID = "school_id";

	public final static String ALBUM_NAME = "school_name";
	public final static String LEVEL = "level";
	public final static String YEAR = "year";
	public final static String CITY = "city";
	public final static String DISTRICT = "district";
	public final static String DATE = "date";
	public final static String DEVICEID = "uuid";
	public final static String PASSWORD = "pass";
	public final static String POINT = "point";
	public final static String FILE = "file";
	public final static String FILE_ID = "file_id";
	public final static String ALBUM_ID = "album_id";
	public final static String USER_ID = "user_id";
	public final static String SEX = "sex";
	public final static String STATUS = "status";
	public final static String OFFSET = "offset";
	public final static String LIMIT = "limit";
	public final static int LIMIT_QUANTITY = 20;
	public final static String ALBUM = "album";
}
