// +----------------------------------------------------------------------
// | Project:   DMgame
// +----------------------------------------------------------------------
// | CreateTime: 04/15/2016 20:48 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.boxfish.ming.dmgame.ui.presenterimp;

import com.boxfish.ming.dmgame.interactors.ChapterInteractor;
import com.boxfish.ming.dmgame.ui.commons.BasePresenterImp;
import com.boxfish.ming.dmgame.ui.features.IChapter;
import com.boxfish.ming.dmgame.ui.presenter.ChapterPresenter;

/**
* DESC   :
* AUTHOR : Xabad
*/
public class ChapterPresenterImp extends BasePresenterImp implements ChapterPresenter {
    ChapterInteractor interactor;
    IChapter viewInterface;
    public ChapterPresenterImp(IChapter viewInterface,ChapterInteractor chapterInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = chapterInteractor;
    }
}
