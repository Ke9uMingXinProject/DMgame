package com.boxfish.ming.dmgame.ui.presenterimp;

import com.boxfish.ming.dmgame.interactors.MainInteractors;
import com.boxfish.ming.dmgame.ui.commons.BasePresenterImp;
import com.boxfish.ming.dmgame.ui.features.IMainView;
import com.boxfish.ming.dmgame.ui.presenter.MainPresenter;

// +----------------------------------------------------------------------
// | CreateTime: 16/4/15 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.zhangkun.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public class MainPresenterImp extends BasePresenterImp implements MainPresenter {

    IMainView mainViewInterface;
    MainInteractors mainInteractors;

    public MainPresenterImp(IMainView mainViewInterface, MainInteractors mainInteractors) {
        super();
        this.mainViewInterface = mainViewInterface;
        this.mainInteractors = mainInteractors;
    }

}
