package com.agvahealthcare.ventilator_ext;

import com.agvahealthcare.ventilator_ext.presentation.ui.activities.MainActivity_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.activities.StandByActivity_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.CommonFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.CommonSubMenuFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.ControlFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.MenuFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.ModeFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.charts.FlowChartFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.charts.PressureChartFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments.AdvancedFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments.BasicFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments.IntelliFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.AdvancedCalibrationFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.AlarmLimitsFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.CalibrationFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.ErrorLogsFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.EventFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.InfoFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.RecentPatientsFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.ServiceFragment_GeneratedInjector;
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.AlarmViewModel_HiltModules;
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel_HiltModules;
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.EventViewModel_HiltModules;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import dagger.hilt.android.scopes.ServiceScoped;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.android.scopes.ViewScoped;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.migration.DisableInstallInCheck;
import javax.inject.Singleton;

public final class Sedation_App_HiltComponents {
  private Sedation_App_HiltComponents() {
  }

  @Module(
      subcomponents = ServiceC.class
  )
  @DisableInstallInCheck
  abstract interface ServiceCBuilderModule {
    @Binds
    ServiceComponentBuilder bind(ServiceC.Builder builder);
  }

  @Module(
      subcomponents = ActivityRetainedC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityRetainedCBuilderModule {
    @Binds
    ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
  }

  @Module(
      subcomponents = ActivityC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityCBuilderModule {
    @Binds
    ActivityComponentBuilder bind(ActivityC.Builder builder);
  }

  @Module(
      subcomponents = ViewModelC.class
  )
  @DisableInstallInCheck
  abstract interface ViewModelCBuilderModule {
    @Binds
    ViewModelComponentBuilder bind(ViewModelC.Builder builder);
  }

  @Module(
      subcomponents = ViewC.class
  )
  @DisableInstallInCheck
  abstract interface ViewCBuilderModule {
    @Binds
    ViewComponentBuilder bind(ViewC.Builder builder);
  }

  @Module(
      subcomponents = FragmentC.class
  )
  @DisableInstallInCheck
  abstract interface FragmentCBuilderModule {
    @Binds
    FragmentComponentBuilder bind(FragmentC.Builder builder);
  }

  @Module(
      subcomponents = ViewWithFragmentC.class
  )
  @DisableInstallInCheck
  abstract interface ViewWithFragmentCBuilderModule {
    @Binds
    ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
  }

  @Component(
      modules = {
          ApplicationContextModule.class,
          HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class,
          ActivityRetainedCBuilderModule.class,
          ServiceCBuilderModule.class
      }
  )
  @Singleton
  public abstract static class SingletonC implements Sedation_App_GeneratedInjector,
      FragmentGetContextFix.FragmentGetContextFixEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint,
      ServiceComponentManager.ServiceComponentBuilderEntryPoint,
      SingletonComponent,
      GeneratedComponent {
  }

  @Subcomponent
  @ServiceScoped
  public abstract static class ServiceC implements ServiceComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ServiceComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          AlarmViewModel_HiltModules.KeyModule.class,
          CommonViewModel_HiltModules.KeyModule.class,
          EventViewModel_HiltModules.KeyModule.class,
          HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class,
          ActivityCBuilderModule.class,
          ViewModelCBuilderModule.class
      }
  )
  @ActivityRetainedScoped
  public abstract static class ActivityRetainedC implements ActivityRetainedComponent,
      ActivityComponentManager.ActivityComponentBuilderEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityRetainedComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          HiltWrapper_ActivityModule.class,
          HiltWrapper_DefaultViewModelFactories_ActivityModule.class,
          FragmentCBuilderModule.class,
          ViewCBuilderModule.class
      }
  )
  @ActivityScoped
  public abstract static class ActivityC implements MainActivity_GeneratedInjector,
      StandByActivity_GeneratedInjector,
      ActivityComponent,
      DefaultViewModelFactories.ActivityEntryPoint,
      HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint,
      FragmentComponentManager.FragmentComponentBuilderEntryPoint,
      ViewComponentManager.ViewComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          AlarmViewModel_HiltModules.BindsModule.class,
          CommonViewModel_HiltModules.BindsModule.class,
          EventViewModel_HiltModules.BindsModule.class,
          HiltWrapper_HiltViewModelFactory_ViewModelModule.class
      }
  )
  @ViewModelScoped
  public abstract static class ViewModelC implements ViewModelComponent,
      HiltViewModelFactory.ViewModelFactoriesEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewModelComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewC implements ViewComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewComponentBuilder {
    }
  }

  @Subcomponent(
      modules = ViewWithFragmentCBuilderModule.class
  )
  @FragmentScoped
  public abstract static class FragmentC implements CommonFragment_GeneratedInjector,
      CommonSubMenuFragment_GeneratedInjector,
      ControlFragment_GeneratedInjector,
      MenuFragment_GeneratedInjector,
      ModeFragment_GeneratedInjector,
      FlowChartFragment_GeneratedInjector,
      PressureChartFragment_GeneratedInjector,
      AdvancedFragment_GeneratedInjector,
      BasicFragment_GeneratedInjector,
      IntelliFragment_GeneratedInjector,
      AdvancedCalibrationFragment_GeneratedInjector,
      AlarmLimitsFragment_GeneratedInjector,
      CalibrationFragment_GeneratedInjector,
      ErrorLogsFragment_GeneratedInjector,
      EventFragment_GeneratedInjector,
      InfoFragment_GeneratedInjector,
      RecentPatientsFragment_GeneratedInjector,
      ServiceFragment_GeneratedInjector,
      FragmentComponent,
      DefaultViewModelFactories.FragmentEntryPoint,
      ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends FragmentComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewWithFragmentC implements ViewWithFragmentComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewWithFragmentComponentBuilder {
    }
  }
}
