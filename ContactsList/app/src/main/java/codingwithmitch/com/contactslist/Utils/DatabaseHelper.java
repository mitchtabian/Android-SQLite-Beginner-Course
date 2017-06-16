package codingwithmitch.com.contactslist.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import codingwithmitch.com.contactslist.models.Contact;

/**
 * Created by User on 6/13/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts_table";
    public static final String COL0 = "ID";
    public static final String COL1 = "NAME";
    public static final String COL2 = "PHONE_NUMBER";
    public static final String COL3 = "DEVICE";
    public static final String COL4 = "EMAIL";
    public static final String COL5 = "PROFILE_PHOTO";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " +
                TABLE_NAME + " ( " +
                COL0 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 + " TEXT, " +
                COL2 + " TEXT, " +
                COL3 + " TEXT, " +
                COL4 + " TEXT, " +
                COL5 + " TEXT )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * Insert a new contact into the database
     * @param contact
     * @return
     */
    public boolean addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, contact.getName());
        contentValues.put(COL2, contact.getPhonenumber());
        contentValues.put(COL3, contact.getDevice());
        contentValues.put(COL4, contact.getEmail());
        contentValues.put(COL5, contact.getProfileImage());

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Retrieve all contacts from database
     * @return
     */
    public Cursor getAllContacts(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    /**
     * Update a contact where id = @param 'id'
     * Replace the current contact with @param 'contact'
     * @param contact
     * @param id
     * @return
     */
    public boolean updateContact(Contact contact, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, contact.getName());
        contentValues.put(COL2, contact.getPhonenumber());
        contentValues.put(COL3, contact.getDevice());
        contentValues.put(COL4, contact.getEmail());
        contentValues.put(COL5, contact.getProfileImage());

        int update = db.update(TABLE_NAME, contentValues, COL0 + " = ? ", new String[] {String.valueOf(id)} );

        if(update != 1) {
            return false;
        }
        else{
                return true;
            }
    }

    /**
     * Retrieve the contact unique id from the database using @param
     * @param contact
     * @return
     */
    public Cursor getContactID(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME  +
                " WHERE " + COL1 + " = '" + contact.getName() + "'" +
                " AND " + COL2 + " = '" + contact.getPhonenumber() + "'";
        return db.rawQuery(sql, null);
    }

    public Integer deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {String.valueOf(id)});
    }

}







