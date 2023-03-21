## Core бібліотека для mixdirnks.org

Тут увесь код що шариться між проектами: backend та android (потенційно ios)
Це все написано на Kotlin Multiplatform тому в теорії можете їх зкомпілювати і на {тут підставте свою платформу},
kotlin зміє в bytecode тому в теорії має все працювати.

### В проекті є наступне

#### DTO

DTO об'єкти, промарковані анотаціями для серіалізації з попомогою бібліотеки kotlinx.serialization

- SnapshotDto - мета інфо про коктейлі плсю список коктейлів, приладдя, бокалів, фільтрів ....
- CocktailDto - Коктейль, включає в себе інгредієнти та приладдя
- FilterGroupDto - група фільтрів для прикладу "Смак" або "Рівень алкоголю"
- FilterWithCocktailIdsDto - тут назва фільтра та список id коктейлів які відповідають цьому фільтру

#### CocktailsFilter

Клас CocktailsFilter для фільтрації коктейлів по різним параметрам.
Приймає в констурктор усю мета інфо можна взяти з обєкта Snapshot

---

Бібліотека є на maven central.

#### Install
##### kotlin Multiplatfrom
```kotlin
val commonMain by getting {
  dependencies {
    implementation("org.mixdrinks:core:<version>")
  }
}
```

##### Android / JVM
```kotlin
dependencies {
  implementation("org.mixdrinks:core-jvm:<version>")
}
```

##### Versions
For use stable version use repository tags, example `1.7.0`
Also our ci generate the version for each pull request the version has the following format `<last_tag>-<commit_shart_sha>`, example `1.7.0-fedcba9`
