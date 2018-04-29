# tweeter (Assignment - Project TwitSplit)
android-kotlin-mvp-dragger

```splitMessage``` is Test in FragmentUserInputPresenterUnitTest

unit teststructure
```
.
├── ExampleUnitTest.kt
├── FragmentListStatusPresenterUnitTest.kt
└── FragmentUserInputPresenterUnitTest.kt
```
app structure
```
.
├── App.kt
├── data
│   ├── DataRepository.kt
│   ├── DataSource.kt
│   └── local
│       ├── LocalRepository.kt
│       └── LocalResource.kt
├── di
│   ├── AppComponent.kt
│   └── AppModule.kt
├── domain
│   └── usecase
│       └── ListStatusUseCase.kt
├── model
│   └── Status.kt
├── ui
│   ├── adapter
│   │   └── StatusRecycleAdapter.kt
│   ├── contact
│   │   ├── FragmentListStatusContact.kt
│   │   ├── FragmentUserInputContact.kt
│   │   └── MainActivityContact.kt
│   ├── listener
│   │   └── ListStatusFragmentListItemListener.kt
│   ├── presenter
│   │   ├── BasePresenter.kt
│   │   ├── FragmentListStatusPresenter.kt
│   │   ├── FragmentUserInputPresenter.kt
│   │   └── MainPresenter.kt
│   └── view
│       ├── FragmentListStatus.kt
│       ├── FragmentUserInput.kt
│       ├── MainActivity.kt
│       └── base
│           ├── BaseActivity.kt
│           ├── BaseFragment.kt
│           └── BaseView.kt
└── utils
    ├── InputStatusState.kt
    └── StringUtils.kt
```    
