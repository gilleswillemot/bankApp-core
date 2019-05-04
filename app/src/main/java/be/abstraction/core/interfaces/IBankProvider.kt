package be.abstraction.core.interfaces

import be.abstraction.core.models.Bank

interface IBankProvider {

    fun getBanks(): List<Bank>
}