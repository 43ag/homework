package com.otus.components;

import com.google.inject.Inject;
import com.otus.pageobject.PageObject;
import com.otus.support.GuiceScoped;

public abstract class AbsBaseComponents<C extends AbsBaseComponents> extends PageObject<AbsBaseComponents<AbsBaseComponents>> {
    @Inject
    public AbsBaseComponents(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }
}
