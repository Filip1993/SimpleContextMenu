package com.filipkesteli.simplecontextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        registerContextMenus();
    }

    private void registerContextMenus() {
        registerForContextMenu(etText);
    }

    private void initWidgets() {
        etText = (EditText) findViewById(R.id.etText);
    }

    private EditText etSelected;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        etSelected = (EditText) v;
        menu.setHeaderTitle(R.string.choose);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.miDelete:
                etSelected.setText("");
                return true;
            case R.id.miCancel:
                return true;
        }

        return super.onContextItemSelected(item);
    }
}
