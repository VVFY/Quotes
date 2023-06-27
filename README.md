# Quotes

An old pet project in view system with upgraded dependencies, brought back into existence to demonstrate migration to compose.

### Points to note in this branch and in its related MR.
* Add material2 theme adapter dependency(material 3 will be integrated later on).
* Replace deprecated VerticalPager() composable usage with newer one.
* Use MdcTheme() composable theme wrapper for quote fragment content.
* Due to small amount of theme customization, the rest parts are not much changed.
* Fix minor bug in Event class, which was not letting event marked as used.
* Weird issue: ThemeAdapter version used in this change is not picking up font (other than in textAppearanceHeadline1) when typography is customized through xml theme. May be it is the issue with downloadable fonts with compose. Will be resolved later.
* Previous appCompat textAppearance cleanup.