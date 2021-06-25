package com.dynamicdevz.mobilephonesinventory.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dynamicdevz.mobilephonesinventory.databinding.PhoneItemLayoutBinding;
import com.dynamicdevz.mobilephonesinventory.model.data.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdapter extends BaseAdapter {

//    public interface PhoneDelegate {
//        void selectPhone(Phone phone);
//    }
    private List<Phone> phoneList = new ArrayList<>();

    public PhoneAdapter(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
        notifyDataSetChanged();
    }

    public PhoneAdapter() {
    }


    //private PhoneDelegate phoneDelegate;



    @Override
    public int getCount() {
        return phoneList.size();
    }

    @Override
    public Phone getItem(int i) {
        return phoneList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (long)i;
    }

    private PhoneItemLayoutBinding binding;


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

//        View layout = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.comic_item_layout, viewGroup, false);
        binding = PhoneItemLayoutBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);

        Phone phone = phoneList.get(i);
        binding.nameTextview.setText(phone.getName());
        binding.manufacturerTextview.setText(phone.getManufacturer());
        binding.modelTextview.setText(phone.getModel());
        binding.priceTextview.setText("Price: $"+phone.getPrice());

//        binding.getRoot().setOnClickListener(v -> {
//            phoneDelegate.selectPhone(phone);
//        });
        return binding.getRoot();
    }

}
