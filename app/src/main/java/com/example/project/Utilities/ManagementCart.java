package com.example.project.Utilities;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.project.Activity.LoginActivity;
import com.example.project.Interface.ChangeNumberItemsListener;
import com.example.project.Model.MusicDeviceOrder;
import com.example.project.Model.MusicDeviceOrders;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertMusicDeviceOrder(MusicDeviceOrder item) {
        ArrayList<MusicDeviceOrder> listmusicDevice = getListCard();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listmusicDevice.size(); i++) {
            if (listmusicDevice.get(i).getMusicDevice().getId().equals(item.getMusicDevice().getId())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listmusicDevice.get(n).setNum(item.getNum());
        } else {
            listmusicDevice.add(item);
        }

        tinyDB.putListObject("CardList", listmusicDevice);
        Toast.makeText(context, "Added To Your Card", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<MusicDeviceOrder> getListCard() {
        return tinyDB.getListObject("CardList");
    }

    public void plusNumberFood(ArrayList<MusicDeviceOrder> listmusicDevice, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listmusicDevice.get(position).setNum(listmusicDevice.get(position).getNum() + 1);
        tinyDB.putListObject("CardList", listmusicDevice);
        changeNumberItemsListener.changed();
    }

    public void MinusNumerFood(ArrayList<MusicDeviceOrder> listmusicDevice, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listmusicDevice.get(position).getNum() == 1) {
            listmusicDevice.remove(position);
        } else {
            listmusicDevice.get(position).setNum(listmusicDevice.get(position).getNum()-1);
        }
        tinyDB.putListObject("CardList", listmusicDevice);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<MusicDeviceOrder> listp = getListCard();
        double fee = 0;
        for (int i = 0; i < listp.size(); i++) {
            fee = fee + (listp.get(i).getMusicDevice().getPrice() * listp.get(i).getNum());
        }
        return fee;
    }

    public void payment() throws IOException {
        if(!getListCard().isEmpty()){new PostDataTask().execute();}
        else {System.out.println("Errore");}
    }
    private class PostDataTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            MusicDeviceOrders po = new MusicDeviceOrders(getListCard());
            Gson gson = new Gson();
            HttpHandler httpHandler = new HttpHandler();
            httpHandler.sendHTTPData("http://172.18.69.128:8080/api/orders", po);
            return null;
        }

        @Override
        protected void onPostExecute(String dataFetched) {
            //parse the JSON data and then display
        }

    }

}
