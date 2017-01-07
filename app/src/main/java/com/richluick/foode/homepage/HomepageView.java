package com.richluick.foode.homepage;

import com.richluick.foode.elements.ElementView;
import com.richluick.foode.view.View;

import java.util.List;

/**
 * Created by rluick on 1/7/2017.
 */
public interface HomepageView extends View {

    void setupElementViewAdapter(List<ElementView> elementViewList);
}
