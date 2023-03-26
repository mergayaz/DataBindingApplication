package kz.kuz.databinding

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kz.kuz.databinding.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    // в build.gradle(app) добавлена часть dataBinding она необходима для привязки данных
    // также макет XML обёрнут тегом <layout> (в файле макета подробное описание)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity!!.setTitle(R.string.toolbar_title)
        // в случае использования привязки данных строка ниже уже не нужна
//        View view = inflater.inflate(R.layout.fragment_main, container, false);
        // класс FragmentMainBinding создаётся механизмом привязки данных автоматически на основе
        // файла макета fragment_main
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main,
                container, false)
        // создаём новый экземпляр SomeClass с переменной "bugaga" и передаём его в binding
        val newClass = SomeClass("bugaga")
        binding.setSomeModel(newClass)
        // ставим слушателей на первую кнопку и на поле ввода при нажатии Enter
        binding.btn1.setOnClickListener { ButtonTitleChange() }
        binding.editText.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN &&
                    keyCode == KeyEvent.KEYCODE_ENTER) {
                ButtonTitleChange()
            }
            false
        }

        // в случае использования привязки данных строка ниже не нужна
//        return view;
        return binding.getRoot()
    }

    fun ButtonTitleChange() {
        val text = binding.editText.text.toString()
        val someClass = SomeClass(text)
        binding.someModel = someClass
        binding.editText.text.clear()
        binding.executePendingBindings()
        // данная команда приказывает макету binding немедленно обновить себя
        // обычно это не нужно, но иногда бывает полезно (например, в случае RecyclerView,
        // когда view создаются с высокой скоростью
    }
}