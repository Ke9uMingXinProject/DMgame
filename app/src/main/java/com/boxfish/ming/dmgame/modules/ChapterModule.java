// +----------------------------------------------------------------------
// | Project:   DMgame
// +----------------------------------------------------------------------
// | CreateTime: 04/15/2016 20:48 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.boxfish.ming.dmgame.modules;


import com.boxfish.ming.dmgame.interactors.ChapterInteractor;
import com.boxfish.ming.dmgame.ui.features.IChapter;
import com.boxfish.ming.dmgame.ui.presenter.ChapterPresenter;
import com.boxfish.ming.dmgame.ui.presenterimp.ChapterPresenterImp;

import dagger.Module;
import dagger.Provides;

@Module
public class ChapterModule {

    private IChapter viewInterface;

    public ChapterModule(IChapter viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Provides
    public IChapter getViewInterface() {
        return viewInterface;
    }
    @Provides
    public ChapterPresenter getPresenter(IChapter viewInterface,ChapterInteractor chapterInteractor){
        return new ChapterPresenterImp(viewInterface,chapterInteractor);
    }
}