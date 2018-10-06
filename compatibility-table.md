# Espresso : Jack-knife compatibility table
| Espresso                                  | Jack-knife                                            |
| ----------------------------------------- | ----------------------------------------------------- |
| withAlpha(float)                          | @WithAlpha(float)                                     |
| withContentDescription(String)            | @WithContentDescription(String)                       |
| withContentDescription(@StringRes int)    | @WithContentDescription(fromResource = @StringRes)    |
| withContentDescription(Matcher<String>)   | [use custom matcher](use-custom-matcher.md)           |
| withChild(Matcher<View>)                  | [use custom matcher](use-custom-matcher.md)           |                                   
| withClassName(Matcher<String>)            | [use custom matcher](use-custom-matcher.md)           |
| withEffectiveVisibility(Visibility)       | @WithEffectiveVisibility(Visibility)                  |
| withHint(int)                             | @WithHint(fromResource = @StringRes)                  |
| withHint(String hintText)                 | @WithHint(String)                                     |
| withHint(Matcher<String>)                 | [use custom matcher](use-custom-matcher.md)           |
| withId(int)                               | @WithId(@ResId int)                                   |
| withId(Matcher<Integer>)                  | [use custom matcher](use-custom-matcher.md)           |
| withInputType(int)                        | @WithInputType(int)                                   |
| withResourceName(String)                  | *)                                                    |
| withResourceName(Matcher<String>)         | [use custom matcher](use-custom-matcher.md)           |
| withSpinnerText(int)                      | *)                                                    |
| withSpinnerText(Matcher<String>)          | [use custom matcher](use-custom-matcher.md)           |
| withSpinnerText(String)                   | *)                                                    |
| withSubstring(String)                     | *)                                                    |
| withTagKey(int)                           | @WithTagKey(int)                                      |
| withTagKey(int, Matcher<Object>)          | [use custom matcher](use-custom-matcher.md)           |
| withTagValue(Matcher<Object>)             | [use custom matcher](use-custom-matcher.md)           |
| withText(String)                          | @WithText(String)                                     |
| withText(int)                             | @WithText(fromResource = @StringRes)                  |
| withText(Matcher<String>)                 | [use custom matcher](use-custom-matcher.md)           |
| withParentIndex(int)                      | *)                                                    |
| withParent(Matcher<View>)                 | [use custom matcher](use-custom-matcher.md)           |
| isAssignableFrom(Class)                   | @IsAssignableFrom(Class)                              |
| isDisplayed()                             | *)                                                    |
| isChecked()                               | *)                                                    |
| isClickable()                             | *)                                                    |
| isCompletelyDisplayed()                   | *)                                                    |
| isDisplayingAtLeast(int)                  | *)                                                    |
| isDescendantOfA(int)                      | @IsDescendantOfA(@ResId int)                          |
| isDescendantOfA(Matcher<View>)            | [use custom matcher](use-custom-matcher.md)           |
| isEnabled()                               | *)                                                    |
| isFocusable()                             | *)                                                    |
| isJavascriptEnabled()                     | *)                                                    |
| isNotChecked()                            | *)                                                    |       
| isRoot()                                  | *)                                                    |
| isSelected()                              | *)                                                    |
| hasBackground(int)                        | *)                                                    |
| hasChildCount(int)                        | *)                                                    |
| hasContentDescription()                   | *)                                                    |
| hasDescendant(Matcher<View>)              | [use custom matcher](use-custom-matcher.md)           |
| hasErrorText(Matcher<String>)             | [use custom matcher](use-custom-matcher.md)           |
| hasErrorText(String)                      | *)                                                    |
| hasFocus()                                | *)                                                    |
| hasImeAction(int)                         | *)                                                    |
| hasImeAction(Matcher<Integer>)            | [use custom matcher](use-custom-matcher.md)           |
| hasLinks()                                | *)                                                    |
| hasMinimumChildCount(int)                 | *)                                                    |
| hasSibling(Matcher<View>)                 | [use custom matcher](use-custom-matcher.md)           |
| hasTextColor(int)                         | *)                                                    |
| assertThat(T, Matcher<T>)                 | This approach is against Page Object Model pattern.   |
| assertThat(String, T, Matcher<T>)         | This approach is against Page Object Model pattern.   |
| supportsInputMethods()                    | *)                                                    |

* available soon, for now please use custom matcher