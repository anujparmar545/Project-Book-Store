package com.example.rtpl.rlogin;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidquery.AQuery;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.os.Build.ID;


public class SubscriberInfo extends Fragment {
    Button Hardware, Package, btnHardware;
    private ProgressDialog progressDialog;
    ListView lv;
    ArrayList<MT> al;
    ArrayList<MT1> all;
    private AQuery aQuery;
    private AQuery aq;
    ListView lvData;
    List<MT> dataList;
    List<MT1> dataList1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.subscriber_info_fragment, container, false);
        progressDialog = new ProgressDialog(getActivity());


        Hardware = view.findViewById(R.id.btnHardware);
        Hardware = (Button) view.findViewById(R.id.btnHardware);

        Bundle bundle = getArguments();
        final Subscriber subscriber = (Subscriber) bundle.getParcelable("subscriber");
        final Hardware hardware = (Hardware) bundle.getParcelable("hardware");
        if (subscriber != null) {
            TextView tvSubscriberName = view.findViewById(R.id.tvSubscriberName);
            TextView tvAddress = view.findViewById(R.id.tvAddress);
            TextView tvMobileNo = view.findViewById(R.id.tvMobileNo);
            TextView tvSubscriberId = view.findViewById(R.id.tvSubscriberId);

            tvSubscriberName.setText(subscriber.first_name + " " + subscriber.middle_name + " " + subscriber.last_name);
            tvAddress.setText("Address: " + subscriber.address);
            tvMobileNo.setText("Mobiles No.: " + subscriber.mobile);
            tvSubscriberId.setText("Subscriber Id: " + subscriber.id);
            Hardware.setVisibility(View.VISIBLE);
        }

        Button btn = (Button) view.findViewById(R.id.btnHardware);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv = (ListView) view.findViewById(R.id.lvData);
                al = new ArrayList<>();
                aQuery = new AQuery(getActivity());
                dataList = new ArrayList<>();
                if (subscriber != null) {
                    Bundle bundle = getArguments();
                    final Subscriber subscriber = (Subscriber) bundle.getParcelable("subscriber");
                    subscriber.getId();
                    bundle.putString("ID", ID);
                    }
                    showHardware("ID");
                    return;
                }
        });
//                Bundle bundle = getArguments();
//                final Subscriber subscriber = (Subscriber) bundle.getParcelable("subscriber");
//                bundle.putString("Id", "ID");
//                subscriber.getId();


        Button button = (Button) view.findViewById(R.id.btnPackage1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList1 = new ArrayList<>();
                lv = (ListView) view.findViewById(R.id.lvData);
                all = new ArrayList<>();
                aQuery = new AQuery(getActivity());
                Bundle bundle = getArguments();
                final Subscriber subscriber = (Subscriber) bundle.getParcelable("subscriber");
                 subscriber.getId();
                 int id = getId();
                 if (id == R.id.tvSUBSCRIBER_ID )
//                int id = getId();
//                if (id == R.id.etSubscriberId) {
//                    return;
//                }
                showPACKAGE("SUB_ID");
                return;
            }
        });
        return view;
    }
    private void showHardware(final String filter) {

        progressDialog.setMessage("Fetching hardware . . .");
        progressDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String response = null;
        final String finalResponse = response;

        StringRequest postRequest = new StringRequest(Request.Method.POST, AppMethods.ServiceType.Get_Hardware_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {

                        try {
                            progressDialog.hide();
                            JSONObject obj = new JSONObject(response);
                            String status = obj.getString("status");
                            if (status.equals("true")) {
                                JSONArray jsonArray = obj.getJSONArray("data");
                                JSONObject DataList = jsonArray.getJSONObject(0);
                                MT mt = new MT(DataList.getString("CARD_SERIAL_NO"),
                                        DataList.getString("CARD_BRAND_NAME"),
                                        DataList.getString("STB_SERIAL_NO"),
                                        DataList.getString("STB_BRAND_NAME"));

                                dataList.add(mt);

                                ListViewAdapter adapter = new ListViewAdapter(dataList, getContext());
                                lv.setAdapter(adapter);
                            } else {
                                Toast.makeText(getActivity(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Log.d("ErrorResponse", finalResponse);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                if (filter == "ID") {
                    params.put("ID", filter);
                }
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);
    }

    class MT {

        String CARD_SERIAL_NO, CARD_BRAND_NAME, STB_SERIAL_NO, STB_BRAND_NAME;

        public MT(String CARD_SERIAL_NO, String CARD_BRAND_NAME, String STB_SERIAL_NO, String STB_BRAND_NAME) {
            this.CARD_SERIAL_NO = CARD_SERIAL_NO;
            this.CARD_BRAND_NAME = CARD_BRAND_NAME;
            this.STB_SERIAL_NO = STB_SERIAL_NO;
            this.STB_BRAND_NAME = STB_BRAND_NAME;
        }

        public String getCARD_SERIAL_NO() {
            return CARD_SERIAL_NO;
        }

        public String getCARD_BRAND_NAME() {
            return CARD_BRAND_NAME;
        }

        public String getSTB_SERIAL_NO() {
            return STB_SERIAL_NO;
        }

        public String getSTB_BRAND_NAME() {
            return STB_BRAND_NAME;
        }
    }

    class ListViewAdapter extends ArrayAdapter<MT> {

        private List<MT> DataList;

        private Context mCtx;


        public ListViewAdapter(List<MT> dataList, Context mCtx) {
            super(mCtx, R.layout.mydata, dataList);
            this.DataList = dataList;
            this.mCtx = mCtx;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(mCtx);

            View listViewItem = inflater.inflate(R.layout.mydata, null, true);
            TextView tvCARD_SERIAL_NO = listViewItem.findViewById(R.id.tvCARD_SERIAL_NO);
            TextView tvCARD_BRAND_NAME = listViewItem.findViewById(R.id.tvCARD_BRAND_NAME);
            TextView tvSTB_SERIAL_NO = listViewItem.findViewById(R.id.tvSTB_SERIAL_NO);
            TextView tvSTB_BRAND_NAME = listViewItem.findViewById(R.id.tvSTB_BRAND_NAME);


            MT mt = DataList.get(position);
            tvCARD_SERIAL_NO.setText("CARD_SERIAL_NO  :  " + mt.CARD_SERIAL_NO);
            tvCARD_BRAND_NAME.setText("CARD_BRAND_NAME  :  " + mt.CARD_BRAND_NAME);
            tvSTB_SERIAL_NO.setText("STB_SERIAL_NO  :  " + mt.STB_SERIAL_NO);
            tvSTB_BRAND_NAME.setText("STB_BRAND_NAME  :  " + mt.STB_BRAND_NAME);
            return listViewItem;
        }
    }

    private void showPACKAGE(final String filter) {

        progressDialog.setMessage("Fetching package . . .");
        progressDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String response = null;
        final String finalResponse = response;

        StringRequest postRequest = new StringRequest(Request.Method.POST, AppMethods.ServiceType.Get_package,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {
                        try {
                            progressDialog.hide();
                            JSONObject obj1 = new JSONObject(response);
                            String status = obj1.getString("status");
                            if (status.equals("true")) {
                                JSONArray jsonArray = obj1.getJSONArray("data");
                                JSONObject DataList1 = jsonArray.getJSONObject(0);
                                MT1 mt1 = new MT1(DataList1.getString("PACK_ID"),
                                        DataList1.getString("PACKAGE_NAME"),
                                        DataList1.getString("CHANNEL_NAME"),
                                        DataList1.getString("CHANNEL_ID"));
                                dataList1.add(mt1);

                                ListViewAdapter1 adapter1 = new ListViewAdapter1(dataList1, getContext());
                                lv.setAdapter(adapter1);
                            } else {
                                Toast.makeText(getActivity(), obj1.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Log.d("ErrorResponse", finalResponse);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("SUB_ID", filter);
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);
    }

    class MT1 {
        String PACK_ID, PACKAGE_NAME, CHANNEL_ID, CHANNEL_NAME;

        public MT1(String PACK_ID, String PACKAGE_NAME, String CHANNEL_NAME, String CHANNEL_ID) {
            this.PACK_ID = PACK_ID;
            this.PACKAGE_NAME = PACKAGE_NAME;
            this.CHANNEL_NAME = CHANNEL_NAME;
            this.CHANNEL_ID = CHANNEL_ID;
        }

        public String getPACK_ID() {
            return PACK_ID;
        }

        public String getPACKAGE_NAME() {
            return PACKAGE_NAME;
        }

        public String getCHANNEL_NAME() {
            return CHANNEL_NAME;
        }

        public String getCHANNEL_ID() {
            return CHANNEL_ID;
        }

    }

    class ListViewAdapter1 extends ArrayAdapter<MT1> {
        private List<MT1> DataList1;
        private Context mCtx1;
        public ListViewAdapter1(List<MT1> dataList1, Context mCtx1) {
            super(mCtx1, R.layout.mydata1, dataList1);
            this.DataList1 = dataList1;
            this.mCtx1 = mCtx1;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(mCtx1);

            View listViewItem = inflater.inflate(R.layout.mydata1, null, true);
            TextView textViewPACK_ID = listViewItem.findViewById(R.id.tvPACK_ID);
            TextView textViewPACKAGE_NAME = listViewItem.findViewById(R.id.tvPACKAGE_NAME);
            TextView textViewCHANNEL_NAME = listViewItem.findViewById(R.id.tvCHANNEL_NAME);
            TextView textViewCHANNEL_ID = listViewItem.findViewById(R.id.tvCHANNEL_ID);


            MT1 mt1 = DataList1.get(position);
            textViewPACK_ID.setText("PACK_ID  :  " + mt1.PACK_ID);
            textViewPACKAGE_NAME.setText("PACKAGE_NAME  :  " + mt1.PACKAGE_NAME);
            textViewCHANNEL_NAME.setText("CHANNEL_NAME  :  " + mt1.CHANNEL_NAME);
            textViewCHANNEL_ID.setText("CHANNEL_ID  :  " + mt1.CHANNEL_ID);
            return listViewItem;
        }
    }
}
