package com.drive.drive_driver.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.drive.drive_driver.R;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;


public class HomeFragment extends Fragment implements View.OnClickListener, OnMapReadyCallback {

    private View view;
    private GoogleMap map;
    private Button btn_start, btn_continue_safety, btn_online, btn_cancel, btn_accept;
    private BottomSheetBehavior<LinearLayout> behavior, behavior1, behavior_safety;
    private LinearLayout bottomsheeet, bottomsheet1, bottomsheet_safety;
    private AdvanceDrawerLayout advance_drawer;
    private TextView earning_all, last_trip;
    private ImageView user_pic, gift, safety_toolkit, all_documents_vehicle;
    private LinearLayout nav_profile, ll_trip_check;
    private CardView card1;
    private FloatingActionMenu material_design_android_floating_action_menu;
    private FloatingActionButton floating_action_menu_request_test, floating_action_menu_tripSetting, floating_action_menu_driving_hour;
    private TextView nav_my_vehicle, nav_settings, nav_drive_partner, nav_inbox, nav_account;

    private int data = 0;
    private int ride = 0;
    private int on = 1;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        ids();
        setup();
        performActions();
        openLayout();
//        if (on== 0) {
//            openAlertRide();
//        }
        return view;
    }

    private void openAlertRide() {
        if (ride == 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    behavior1.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }, 2000);
        } else {
            behavior1.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }

    private void openLayout() {
        if (data == 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.lefttoright);
                    last_trip.setAnimation(animation);
                    last_trip.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.righttoleft);
                            last_trip.setAnimation(animation);
                            last_trip.setVisibility(View.GONE);
                            openLayout();
                        }
                    }, 10000);
                }
            }, 5000);
        } else {
            last_trip.setVisibility(View.GONE);
        }
    }

    private void performActions() {
        advance_drawer.useCustomBehavior(Gravity.START);
        advance_drawer.setRadius(Gravity.START, 35);//set end container's corner radius (dimension)
        advance_drawer.setViewScale(Gravity.START, 0.9f);
        advance_drawer.setViewElevation(Gravity.START, 20);
    }

    private void setup() {
        user_pic.setOnClickListener(this);
        ll_trip_check.setOnClickListener(this);
        safety_toolkit.setOnClickListener(this);
        all_documents_vehicle.setOnClickListener(this);
        gift.setOnClickListener(this);
        nav_my_vehicle.setOnClickListener(this);
        nav_drive_partner.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        nav_profile.setOnClickListener(this);
        nav_settings.setOnClickListener(this);
        btn_continue_safety.setOnClickListener(this);
        bottomsheet_safety.setOnClickListener(this);
        earning_all.setOnClickListener(this);
        last_trip.setOnClickListener(this);
        btn_online.setOnClickListener(this);
        btn_accept.setOnClickListener(this);
        nav_inbox.setOnClickListener(this);
        nav_account.setOnClickListener(this);


        //click on floating
        floating_action_menu_request_test.setOnClickListener(this);
        floating_action_menu_tripSetting.setOnClickListener(this);
        floating_action_menu_driving_hour.setOnClickListener(this);

    }

    private void ids() {
        user_pic = view.findViewById(R.id.user_pic);
        safety_toolkit = view.findViewById(R.id.safety_toolkit);
        gift = view.findViewById(R.id.gift);
        btn_start = view.findViewById(R.id.btn_start);
        btn_continue_safety = view.findViewById(R.id.btn_continue_safety);
        nav_my_vehicle = view.findViewById(R.id.nav_my_vehicle);
        nav_drive_partner = view.findViewById(R.id.nav_drive_partner);
        advance_drawer = view.findViewById(R.id.advance_drawer);
        nav_profile = view.findViewById(R.id.nav_profile);
        nav_inbox = view.findViewById(R.id.nav_inbox);
        nav_settings = view.findViewById(R.id.nav_settings);
        nav_account = view.findViewById(R.id.nav_account);
        ll_trip_check = view.findViewById(R.id.ll_trip_check);
        earning_all = view.findViewById(R.id.earning_all);
        last_trip = view.findViewById(R.id.last_trip);
        btn_online = view.findViewById(R.id.btn_online);
        btn_accept = view.findViewById(R.id.btn_accept);
        all_documents_vehicle = view.findViewById(R.id.all_documents_vehicle);

        //floating button
        floating_action_menu_request_test = view.findViewById(R.id.floating_action_menu_request_test);
        material_design_android_floating_action_menu = view.findViewById(R.id.material_design_android_floating_action_menu);
        floating_action_menu_tripSetting = view.findViewById(R.id.floating_action_menu_tripSetting);
        floating_action_menu_driving_hour = view.findViewById(R.id.floating_action_menu_driving_hour);

        //bottom
        bottomsheeet = view.findViewById(R.id.bottomsheet);
        behavior = BottomSheetBehavior.from(bottomsheeet);

        //bottom_ride
        //bottom
        bottomsheet1 = view.findViewById(R.id.bottomsheet1);
        behavior1 = BottomSheetBehavior.from(bottomsheet1);

        //bottom
        bottomsheet_safety = view.findViewById(R.id.bottomsheet_safety);
        behavior_safety = BottomSheetBehavior.from(bottomsheet_safety);

        view.findViewById(R.id.nav_help).setOnClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_pic:
                advance_drawer.openDrawer(GravityCompat.START);
                break;
            case R.id.nav_my_vehicle:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_myVehicleFragment);
                advance_drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_drive_partner:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_drivePartnerFragment);
                advance_drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_profile:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_profileMinorFragment);
                advance_drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_inbox:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_inboxFragment);
                advance_drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_settings:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_settingFragment);
                break;

            case R.id.nav_help:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_helpFragment);
                advance_drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_account:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_accountFragment);
                advance_drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.gift:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_rewardTabFragment);
                break;

            case R.id.safety_toolkit:
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.bottomsheet_safety:

                break;
            case R.id.btn_start:
                on = 0;
                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.zoomout);
                btn_start.setAnimation(animation);
                btn_start.setVisibility(View.GONE);
                Animation animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.zoomin);
                btn_online.setAnimation(animation1);
                btn_online.setVisibility(View.VISIBLE);
                if (btn_online.VISIBLE == on) {
                    openAlertRide();
                }
                break;
            case R.id.btn_online:
                Animation animation3 = AnimationUtils.loadAnimation(getActivity(), R.anim.zoomout);
                btn_online.setAnimation(animation3);
                btn_online.setVisibility(View.GONE);
                Animation animation4 = AnimationUtils.loadAnimation(getActivity(), R.anim.zoomin);
                btn_start.setAnimation(animation4);
                btn_start.setVisibility(View.VISIBLE);
                break;
            case R.id.earning_all:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_earningFragment);
                break;
            case R.id.last_trip:
                final AlertDialog.Builder dialogBuilder1 = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.last_trip_detail_alert, null);
                dialogBuilder1.setView(dialogView);
                final AlertDialog alertDialog1 = dialogBuilder1.create();
                card1 = dialogView.findViewById(R.id.card1);
                alertDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Animation animation_alert = AnimationUtils.loadAnimation(getActivity(), R.anim.lefttoright);
                card1.setAnimation(animation_alert);
                alertDialog1.show();
                break;
            case R.id.all_documents_vehicle:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_allDocumentUploadFragment);
                break;
            case R.id.btn_continue_safety:
                behavior_safety.setState(BottomSheetBehavior.STATE_EXPANDED);
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            case R.id.ll_trip_check:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_tripCheckFragment);
                break;
            case R.id.btn_accept:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_rideAcceptFragment);
                break;
            case R.id.floating_action_menu_request_test:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_activeServiceFragment);
                break;
            case R.id.floating_action_menu_tripSetting:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_tripSettingFragment);
                break;
            case R.id.floating_action_menu_driving_hour:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_drivingHoursFragment);
                break;
        }

    }
}