package br.com.xds.daggerwithrest.main_activity;

import java.util.List;

import javax.inject.Inject;

import br.com.xds.daggerwithrest.model.PostVO;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by matheus on 02/12/16.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    Retrofit retrofit;
    MainActivityContract.View mView;

    @Inject
    public MainActivityPresenter(Retrofit retrofit, MainActivityContract.View mView){
        this.retrofit = retrofit;
        this.mView = mView;
    }


    @Override
    public void loadUsers() {
        retrofit.create(UsersService.class).getUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<PostVO>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<PostVO> posts) {
                        mView.showUsers(posts);
                    }
                });

    }

    private interface UsersService{
        @GET("/posts")
        Observable<List<PostVO>> getUsers();
    }
}
