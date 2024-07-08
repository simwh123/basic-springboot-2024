// URL에 넘어온 매개변수 
import React, { useState, useEffect, useInsertionEffect } from 'react';
import { Link, useParams } from "react-router-dom";
// RestAPI
import axios from 'axios';
// 공통함수 추가
import * as common from '../common/CommonFunc'; 

function BoardDetail() {
    const [board, setBoard] = useState({}); // 딕셔너리 한번에!
    const [replyList, setReplyList] = useState([]); // 마지막!!!
    const params = useParams(null);
    // console.log(params.bno);
    const getBoardDetail = async (bno) => {
        const resp = (await axios.get("http://localhost:8080/api/board/detail/" + bno));

        const resultCode = resp.data.resultCode;
        // console.log(resultCode);
        console.log(resp.data.data);
        if (resultCode == "OK") {
            setBoard(resp.data.data); // data 내용 한번에          
        }

        if (resp.data.data.replyList.length > 0) {
            setReplyList(resp.data.data.replyList); // 마지막!!!
        }
    }

    // 상세 RESTAPI 요청
    useEffect(() => {
        getBoardDetail(params.bno);
    }, []); // useEffect를 사용하지 않으면 무한 로딩발생!!!

    return (
        <div className="container main">
            <h4 className="border-bottom py-2">{board.title}</h4>
            <div className="card my-3">
                <div className="card-body">
                    <div className="card-text">{board.content}</div>
                    <div className="d-flex justify-content-end">
                        {/* <div className="badge bg-light text-dark p-2 text-start mx-3">
                            <div className="mb-2">modified at</div>
                            <div></div>
                        </div> */}
                        <div className="badge bg-light text-dark p-2 text-start">
                            <div className="mb-2">
                                <span>{board.writer}</span>
                            </div>
                            <div>{common.formatDate( board.createDate )}</div>
                        </div>
                    </div>
                    <div className="my-3">
                    </div>
                </div>
            </div>
            <h5 className="border-bottom my-3 py-2">{`${replyList.length}개의 댓글이 있습니다.`}</h5>
            {replyList && replyList.map((reply) => (
                <div className="card my-3" key={reply.rno}>                    
                    <div className="card-body">
                        <div className="card-text">{reply.content}</div>
                        <div className="d-flex justify-content-end">                            
                            <div className="badge bg-light text-dark p-2 text-start">
                                <div className="mb-2">
                                    <span>{reply.writer}</span>
                                </div>
                                <div>{common.formatDate( reply.createDate )}</div>
                            </div>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
}

            export default BoardDetail;