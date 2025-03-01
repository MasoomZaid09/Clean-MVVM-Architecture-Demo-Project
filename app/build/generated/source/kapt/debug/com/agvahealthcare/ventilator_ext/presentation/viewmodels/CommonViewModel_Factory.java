// Generated by Dagger (https://dagger.dev).
package com.agvahealthcare.ventilator_ext.presentation.viewmodels;

import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CommonViewModel_Factory implements Factory<CommonViewModel> {
  private final Provider<Application> applicationProvider;

  public CommonViewModel_Factory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public CommonViewModel get() {
    return newInstance(applicationProvider.get());
  }

  public static CommonViewModel_Factory create(Provider<Application> applicationProvider) {
    return new CommonViewModel_Factory(applicationProvider);
  }

  public static CommonViewModel newInstance(Application application) {
    return new CommonViewModel(application);
  }
}
