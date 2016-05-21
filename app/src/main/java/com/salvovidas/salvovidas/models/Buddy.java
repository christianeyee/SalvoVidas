package com.salvovidas.salvovidas.models;

import com.salvovidas.salvovidas.R;

import java.util.ArrayList;

/**
 * Created by christianeyee on 21/05/2016.
 */

public class Buddy {
    private String name;
    private String mobile;
    private int imgId;

    public Buddy(String name, String mobile, int imgId) {
        this.name = name;
        this.mobile = mobile;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public static ArrayList<Buddy> getData() {
        ArrayList<Buddy> dataList = new ArrayList<>();

        String[] names = getTexts();
        String[] mobiles = getNumbers();
        int[] ids = getIds();

        for (int i=0; i<names.length; i++) {
            Buddy q = new Buddy(names[i], mobiles[i], ids[i]);
            dataList.add(q);
        }
        return dataList;
    }

    private static int[] getIds() {
        return new int[] {
                R.drawable.herbert,
                R.drawable.herbert,
                R.drawable.herbert,
                R.drawable.herbert,
                R.drawable.herbert,
                R.drawable.herbert
        };
    }

    private static String[] getTexts() {
        return new String[] {
                "Herbert Bautista",
                "Ghost Busters",
                "Elias Demetracopoulos",
                "Jenelle Wong",
                "Christiane Yee",
                "Kim Possible",
        };
    }

    private static String[] getNumbers() {
        return new String[] {
                "639258941105",
                "639258941105",
                "639258941105",
                "639258941105",
                "639258941105",
                "639258941105"
        };
    }
}
