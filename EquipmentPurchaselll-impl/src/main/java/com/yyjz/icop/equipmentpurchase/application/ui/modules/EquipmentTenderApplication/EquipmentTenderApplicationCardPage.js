/**
 * Created by ICOP on 2019-04-15.
 */
var React = require('react');
var {YYClass} = require('yylib-ui');
var assign = require('lodash/assign');
var {YYCreatePage} =  require('yylib-business');
var {CardEventHandler} = require('yylib-cscec');
var EquipmentTenderApplicationUrl = require('./EquipmentTenderApplicationUrl');

//页面初始化
var EventHandler = {

    "cardPage": {
        onViewWillMount: function (options) {
            CardEventHandler.pageLoading(this);
        }
        , onViewDidMount: function (options) {
            CardEventHandler.init(this, EquipmentTenderApplicationUrl);
        }
        , onViewWillUpdate: function (options) {

        }
        , onViewDidUpdate: function (options) {

        }
    }
};

var EquipmentTenderApplicationCardPage = YYClass.create({
    render: function () {
        return <YYCreatePage {...this.props} appCode="" pageCode=""
                                             uiEvent={assign({},CardEventHandler.API,EventHandler)} 
                                             uiParser={}/>
    }
});

module.exports = EquipmentTenderApplicationCardPage;