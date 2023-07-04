# Quotes

An old pet project in view system with upgraded dependencies, brought back into existence to demonstrate migration to compose.

### Points to note in this branch and in its related MR.
* Update activity view content to use fragments in compose (This step is optional for this small app, but just for a demonstration).
* Check more details here for using fragments in compose [here](https://developer.android.com/jetpack/compose/migrate/interoperability-apis/views-in-compose#fragments-in-compose).
* Create material2 compose theme named QuotesTheme for the app.
* Remove bridge theme MdcTheme and its dependency.
* Add downloadable fonts for compose. Check here for [info](https://developer.android.com/jetpack/compose/text/fonts#downloadable-fonts)
* Update [compose bom version](https://developer.android.com/jetpack/compose/bom/bom-mapping) to 2023.06.01
* Revert back VerticalPager() composable usage. (The previously used version was updated only with theme adapter, and no more available with current compose version.)