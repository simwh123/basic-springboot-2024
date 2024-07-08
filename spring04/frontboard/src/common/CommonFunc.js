
export function formatDate(date) { // 2024-07-01T09:27:11.269634
    var result = date.replace('T', ' '); // T를 공백으로 변경
    var index = result.lastIndexOf(' ') // 초 앞에 있는 : 위치값, ' '은 yyyy-MM-dd 만 남김

    result = result.substr(0, index); // 초뒤로 삭제
    return result;
}