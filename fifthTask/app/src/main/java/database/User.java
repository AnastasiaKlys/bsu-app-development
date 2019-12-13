package database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey( autoGenerate = true )
    private Long id;
    @ColumnInfo( name = "first_name" )
    private String firstName ;
    @ColumnInfo ( name = "last_name" )
    private String lastName ;
    @ColumnInfo ( name = "date_of_birth" )
    private String dateOfBirth ;

    public Long getId() {
        return id;
    }

    public void setId(Long uid) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Result:" +
                " " + firstName + '\'' +
                " " + lastName + '\'' +
                ", " + dateOfBirth;
    }
}

