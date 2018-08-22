# Google I/O 2018 Schedule App Teardown
https://github.com/google/iosched

https://medium.com/@ersin_ertan/google-i-o-2018-schedule-app-teardown-part-01-dagger-and-databinding-742fb48f5c41
https://medium.com/@ersin_ertan/google-i-o-2018-schedule-app-teardown-part-02-material-and-dataflow-7c2b78544fdf

### Master Branch
[Goto Branch](https://github.com/ersin-ertan/iosched_teardown/tree/master)
- Barebones project using Dagger2 dependency injection via Dagger-Application/AppCompatActivity/Fragment classes
- Injections usage with singleton Analytics object outputing with times counted and calling class, to logs
- Viewmodel injections via ViewModelProvider.Factory and MyViewModelfactory/ViewModelKey
- Parent and child Fragment structure and dependency lifetime scopes

### Databinding Branch
[Goto Branch](https://github.com/ersin-ertan/iosched_teardown/tree/databinding)
- Apply Databinding to layouts and Viewmodels allowing LiveObjects and observers to react based on changes

### Material Branch
[Goto Branch](https://github.com/ersin-ertan/iosched_teardown/tree/material)
- Showcase the Material theme used within app
- Introduce advanced concepts used like delegation

### Experimental Branch - TODO
[Goto Branch](https://github.com/ersin-ertan/iosched_teardown/tree/experimental)
- Add Navigation components
- Use Objectbox as database
- Use binding collection adapters
- Other concepts/libs found on github
