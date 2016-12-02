package br.com.xds.daggerwithrest.main_activity;

import java.util.List;

import br.com.xds.daggerwithrest.model.PostVO;

/**
 * Created by matheus on 02/12/16.
 */

public interface MainActivityContract {

    interface View {
        void showUsers(List<PostVO> users);

        void showError(String message);

        void showComplete();
    }

    interface Presenter{
        void loadUsers();
    }
}
