# Quotes

An old pet project in view system with upgraded dependencies, brought back into existence to demonstrate migration to compose.

### Points to note in this branch and in its related MR.
* Add compose dependencies to coreui module, to make it accessible in feature module and for future in app module.
* compose-lifecycle-runtime dependency is added to collect state from viewModel in compos ein lifecycle aware manner.
* Please watch commits to see step by step conversion of adding compose to existing screen.
* Visit [here](https://medium.com/androiddevelopers/jetpack-compose-interop-using-compose-in-a-recyclerview-569c7ec7a583) for list item view composition strategy doubts, which is no more required.
* Visit [here](https://developer.android.com/jetpack/compose/migrate/interoperability-apis/compose-in-views#composition-strategy) for ViewCompositionStrategy in fragments.
* Details about compose Insets applied in the current change can be found [here](https://developer.android.com/jetpack/compose/layouts/insets#padding-modifiers) 
* At the end, there are no more adapters with recycler view but VerticalPager. Fragment uses view just as a root view, rest in compose.