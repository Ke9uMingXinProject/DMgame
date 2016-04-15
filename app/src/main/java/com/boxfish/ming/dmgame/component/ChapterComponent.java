// +----------------------------------------------------------------------
// | Project:   DMgame
// +----------------------------------------------------------------------
// | CreateTime: 04/15/2016 20:48 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.boxfish.ming.dmgame.component;

import com.boxfish.ming.dmgame.component.commons.ActivityScope;
import com.boxfish.ming.dmgame.interactors.ChapterInteractor;
import com.boxfish.ming.dmgame.modules.ChapterModule;
import com.boxfish.ming.dmgame.ui.fragment.ChapterFragment;
import com.boxfish.ming.dmgame.ui.features.IChapter;
import com.boxfish.ming.dmgame.ui.presenter.ChapterPresenter;

import dagger.Component;

@ActivityScope

@Component(
    dependencies = AppComponent.class,
    modules = ChapterModule.class
)
public interface ChapterComponent {
    void inject(ChapterFragment instance);

    IChapter getViewInterface();

    ChapterPresenter getPresenter();

    ChapterInteractor getChapterInteractor();

}
