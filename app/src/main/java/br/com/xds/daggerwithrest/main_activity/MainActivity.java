package br.com.xds.daggerwithrest.main_activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.xds.daggerwithrest.R;
import br.com.xds.daggerwithrest.application.App;
import br.com.xds.daggerwithrest.databinding.ActivityMainBinding;
import br.com.xds.daggerwithrest.model.PostVO;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    ActivityMainBinding binding;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;

    @Inject
    MainActivityPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        list = new ArrayList<>();

        DaggerMainActivityComponent.builder()
                .netComponent(((App)getApplicationContext()).getmNetComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build().inject(this);

        mainPresenter.loadUsers();
    }

    @Override
    public void showUsers(List<PostVO> users) {
        for (PostVO user:users ) {
            list.add(user.getTitle());
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        binding.usersListView.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
    }
}
