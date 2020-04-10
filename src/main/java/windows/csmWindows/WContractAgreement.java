package windows.csmWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import com.hp.lft.sdk.powerbuilder.Table;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;
import winDataStruct.ContractAgreement;


public class WContractAgreement extends UiActions {

    Table dwSalesContractInfo, dw1, dwCntrAgrmnt, dwAgrmntPrms;
    Button btnNew;

    public WContractAgreement() throws GeneralLeanFtException {
        //*************build this window **************************
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("w_contract_agreement");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);

        //*************window elements **************************
        dwSalesContractInfo = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_sales_contract_info"));
        dw1 = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw1"));
        dwCntrAgrmnt = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_contract_agreement"));
        dwAgrmntPrms = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_agreement_params"));
        btnNew = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_new"));

    }

    public void setContractData(ContractAgreement data) throws GeneralLeanFtException {
        if (data.accoutType!=null && !data.accoutType.trim().isEmpty()) {
            setData(dwCntrAgrmnt, 10, 0, "accout_type_ddlb", data.accoutType);
        }

     //   if (data.salesEntityCode!=null && !data.salesEntityCode.trim().isEmpty()) {
      //      typeData(dwSalesContractInfo, 10, 0, "sales_entity_code", data.salesEntityCode);
      //  }

        if (data.branchCode!=null && !data.branchCode.trim().isEmpty()) {
            String winData = getData(dwSalesContractInfo, 10, 0, "branch_code");
            if (data.branchCode!=null && !data.branchCode.trim().contentEquals(winData)) {
                typeData(dwSalesContractInfo, 10, 0, "branch_code", data.branchCode);
                typeTab(dwSalesContractInfo, 10, 0, "branch_code");
            }
        }

    //    if (data.applicationType!=null && !data.applicationType.trim().isEmpty()) {
    //            String winAppType = getData(dwCntrAgrmnt, 10, 0, "application_type");
      //          if (winAppType.contentEquals("R ") && data.applicationType.contentEquals("מכירה")) {
                    setData(dwCntrAgrmnt, 10, 0, "application_type", data.applicationType);
        //        }
       //     }

        if (data.banCtnLevel!=null && !data.banCtnLevel.trim().isEmpty()) {
                setData(dwCntrAgrmnt, 10, 0, "ban_ctn_level", data.banCtnLevel);
            }

        if (data.immediateActivationInd!=null && !data.immediateActivationInd.trim().isEmpty()) {
                typeData(dwAgrmntPrms, 10, 0, "Immediate_Activation_Ind", data.immediateActivationInd);
            }

        if (data.eqpSrc!=null && !data.eqpSrc.trim().isEmpty()) {
                setData(dwAgrmntPrms, 10, 0, "equipment_source", data.eqpSrc);
            }


        if (data.agrCampaign!=null && !data.agrCampaign.trim().isEmpty()) {
                setData(dw1, 10, 0, "agr_campaign", data.agrCampaign);
            }

     //   if (data.preCampaignDesc!=null && !data.preCampaignDesc.trim().isEmpty()) {
      //          String desc = getData(dw1, 10, 0, "pre_campaign_desc");
      //          if (!desc.trim().contentEquals(data.preCampaignDesc.trim())) {
     //               setData(dw1, 10, 0, "pre_campaign_desc", data.preCampaignDesc);
     //           }
     //       }

        if (data.chgOwnershipBan!=null && !data.chgOwnershipBan.trim().isEmpty()) {
                typeData(dwAgrmntPrms, 10, 0, "chg_ownership_ban", data.chgOwnershipBan);
            }


        }

        public void newAgreement() throws GeneralLeanFtException {
            click(btnNew, 10);
        }



    }
