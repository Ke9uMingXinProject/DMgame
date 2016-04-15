// +----------------------------------------------------------------------
// | Project:   DMgame
// +----------------------------------------------------------------------
// | CreateTime: 04/15/2016 20:48 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.boxfish.ming.dmgame.ui.fragment;

import android.os.Bundle;

import com.boxfish.ming.dmgame.R;
import com.boxfish.ming.dmgame.component.AppComponent;
import com.boxfish.ming.dmgame.component.DaggerChapterComponent;
import com.boxfish.ming.dmgame.modules.ChapterModule;
import com.boxfish.ming.dmgame.ui.commons.BaseFragment;
import com.boxfish.ming.dmgame.ui.features.IChapter;
import com.boxfish.ming.dmgame.ui.presenter.ChapterPresenter;

import javax.inject.Inject;

/**ø
* DESC   :
* AUTHOR : Xabad
*/
public class ChapterFragment extends BaseFragment  implements IChapter{

    @Inject
    ChapterPresenter presenter;

    @Override
    public void getArgs(Bundle bundle) {

    }

    @Override
    public int setView() {
        return R.layout.frg_chapter;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }


    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerChapterComponent.builder()
            .appComponent(appComponent)
            .chapterModule(new ChapterModule(this))
            .build().inject(this);
    }
}
