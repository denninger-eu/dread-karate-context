package eu.k5.dread.karate.test.wsdl.model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "getCountryRequest", namespace = Model.NAMESPACE)
@XmlAccessorType(XmlAccessType.NONE)
class GetCountryRequest {

    @XmlElement(name = "name", namespace = Model.NAMESPACE)
    var name: String? = null

}