package com.devpanther.presenter.home

import com.devpanther.data.database.mock.MockDataBaseData
import com.devpanther.domain.mappers.toEntity
import com.devpanther.domain.model.ChargeInfoModel
import com.devpanther.domain.usecase.RestoreChargeInfoUseCase
import com.devpanther.domain.usecase.StoreChargeInfoUseCase
import com.devpanther.domain.usecase.runAsyncReturnOnMain
import com.devpanther.presenter.base.BasePresenter
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject
import timber.log.Timber

class HomePresenter @Inject constructor(
    private val restoreChargeInfoUseCase: RestoreChargeInfoUseCase,
    private val storeChargeInfoUseCase: StoreChargeInfoUseCase
) : BasePresenter<HomeView>() {

    override fun onFirstBind() {
        super.onFirstBind()

        val data = MockDataBaseData().getChargeInfos()
            .map { it.toEntity() }

        storeChargeInfoUseCase.execute(*data.toTypedArray())
            .runAsyncReturnOnMain()
            .subscribe(
                this::onComplete,
                this::onError
            )
            .addTo(compositeDisposable)
    }

    fun onComplete() {
        Timber.d("Complete")

        restoreChargeInfoUseCase
            .execute()
            .subscribe(
                this::onSuccess,
                this::onError
            )
            .addTo(compositeDisposable)
    }

    fun onSuccess(data: List<ChargeInfoModel>) {
        Timber.d(data.toString())
    }

    fun onError(throwable: Throwable) {
        Timber.d(throwable)
    }
}