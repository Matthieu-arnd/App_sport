package com.example.fit;

import android.os.Parcelable;
import android.os.Parcel;

public class SeanceList implements Parcelable{
    private int id ;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SeanceList(Parcel in ){
        id = in.readInt();
        name = in.readString();

        }
    public SeanceList(){

        }
        @Override
        public void writeToParcel (Parcel dest, int flags){
        dest.writeInt(id);
        dest.writeString(name);
        }
        @Override
        public int describeContents(){
        return 0;
        }
        public static final Creator<SeanceList> CREATOR = new Creator<SeanceList>(){

            @Override
            public SeanceList createFromParcel (Parcel in){
                return new SeanceList(in);
            }
            @Override
            public SeanceList [] newArray(int size){
                return new SeanceList[size];
            }

        };
}
