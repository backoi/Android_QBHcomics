package com.example.qbhcomics.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database_comic extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QBHcomic";
    private static final String TABLE_NAME = "Account";
    private static final String ACCOUNT_ID = "accountID";
    private static final String ACCOUNT_NAME = "acccountName";
    private static final String PASSWORD = "password";
    private static final String PHAN_QUYEN = "phanquyen";
    private static final String EMAIL = "email";
    private static final int VERSION = 1;

    private static final String TABLE_TRUYEN = "truyen";
    private static final String ID_TRUYEN = "idtruyen";
    private static final String TEN_TRUYEN = "tieude";
    private static final String NOI_DUNG = "noidung";
    private static final String IMAGE = "img";


    private Context context;

//    private String SQLQuery = "CREATE TABLE "+ TABLE_TAIKHOAN +" ( "+ID_TAI_KHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT, "
//            +TEN_TAI_KHOAN+" TEXT UNIQUE, "
//            +MAT_KHAU+" TEXT, "
//            +EMAIL+" TEXT, "
//            + PHAN_QUYEN+" INTEGER) ";

//    private String SQLQuery1 = "CREATE TABLE "+ TABLE_TRUYEN +" ( "+ID_TRUYEN+" integer primary key AUTOINCREMENT, "
//            +TEN_TRUYEN+" TEXT UNIQUE, "
//            +NOI_DUNG+" TEXT, "
//            +IMAGE+" TEXT, "+ID_TAI_KHOAN+" INTEGER , FOREIGN KEY ( "+ ID_TAI_KHOAN +" ) REFERENCES "+
//            TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+"))";

//    private String SQLQuery2 = "INSERT INTO TaiKhoan VAlUES (null,'admin','admin','admin@gmail.com',2)";
//    private String SQLQuery3 = "INSERT INTO TaiKhoan VAlUES (null,'lebac','lebac','leebac0802@gmail.com',1)";


    public database_comic(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        // myDB.execSQL("create table "+TABLE_NAME+ "("+ACCOUNT_ID+" integer primary key autoincrement,"+ACCOUNT_NAME+" text,"+PASSWORD+"text) ");

        //myDB.execSQL("create table " +TABLE_NAME+ "(? integer primary key autoincrement,? text,? text)",new String[]{});
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ACCOUNT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ACCOUNT_NAME + " TEXT,"
                + PASSWORD + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        myDB.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop table if exists " + TABLE_NAME);
    }

    public Boolean insertData(String accName, String passWord) {
        boolean check = false;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ACCOUNT_NAME, accName);
        values.put(PASSWORD, passWord);
        long i = db.insert(TABLE_NAME, null, values);
        if (i != -1)
            check = true;
        db.close();

        return check;
    }

    public Boolean checkUser(String acc) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME + " where " + ACCOUNT_NAME + "=?", new String[]{acc});
        return cursor.getCount() > 0;
    }

    public Boolean checkuserPass(String acc, String pass) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME + " where " + ACCOUNT_NAME + "=? and " + PASSWORD + "=?", new String[]{acc, pass});
        return cursor.getCount() > 0;

    }
}
