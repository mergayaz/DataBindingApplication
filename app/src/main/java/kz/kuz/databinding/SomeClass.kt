package kz.kuz.databinding

import android.content.Context
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

// extends BaseObservable не обязателен, он необходим для того, чтобы оповещать макет,
// к которому привязан данный класс об изменениях
class SomeClass(@get:Bindable var string: String) : BaseObservable() {

//    @get:Bindable
//    var someString = string

//    override fun notifyPropertyChanged(title: Int) {
//        super.notifyPropertyChanged(title)
//    }
    // данный метод мне не понятен, вместо title можно поставить что угодно

    fun getTitle(): String {
        return string
    }

    fun CallToast(context: Context?) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

    init {
//        notifyChange()
//        notifyPropertyChanged(BR.title) // не понимает title
        // всё работает без notify
    }
}