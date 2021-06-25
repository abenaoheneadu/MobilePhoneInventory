package com.dynamicdevz.mobilephonesinventory.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.dynamicdevz.mobilephonesinventory.R;
import com.dynamicdevz.mobilephonesinventory.databinding.ActivityMainBinding;
import com.dynamicdevz.mobilephonesinventory.model.data.Phone;
import com.dynamicdevz.mobilephonesinventory.model.db.PhoneDBHelper;
import com.dynamicdevz.mobilephonesinventory.view.adapter.PhoneAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private PhoneDBHelper dbHelper;
private PhoneAdapter phoneAdapter = new PhoneAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.outputListview.setAdapter(phoneAdapter);
        dbHelper = new PhoneDBHelper(this);
        readAllPhones();
        //binding.outputListview.setAdapter(new ArrayAdapter<String>(this, R.layout.phone_item_layout,R.id.name_textview));

        binding.addButton.setOnClickListener(view -> {
            String name = binding.nameEdittext.getText().toString().trim();
            String manufacturer = binding.manufacturerEdittext.getText().toString().trim();
            String model = binding.modelEdittext.getText().toString().trim();
            double price = Double.valueOf(binding.priceEdittext.getText().toString().trim());

            Phone newPhone = new Phone(name, manufacturer,model, price);
            dbHelper.insertPhone(newPhone);
            readAllPhones();
        });
    }

    private void readAllPhones() {
        List<Phone> phones = dbHelper.getAllPhones();
        phoneAdapter.setPhoneList(phones);

    }
}