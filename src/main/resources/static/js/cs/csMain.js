function fn_read(csNumber){
    location.href = "/cs/read?csNumber="+csNumber;
}

//  글 작성시 날짜

const communityTimeElements = document.getElementsByClassName('community-time');


for (let i = 0; i < communityTimeElements.length; i++) {
    const communityTimeElement = communityTimeElements[i];


    const postCreationTime = new Date('2023-06-26T12:00:00Z');


    const currentTime = new Date();
    const timeDifference = currentTime - postCreationTime;


    const seconds = Math.floor(timeDifference / 1000);
    const minutes = Math.floor(seconds / 60);
    const hours = Math.floor(minutes / 60);
    const days = Math.floor(hours / 24);

    let elapsedTime;
    if (days >= 3) {
        elapsedTime = days + '일 전';
    } else if (hours >= 12) {
        const dayCount = Math.ceil(hours / 24);
        elapsedTime = dayCount + '일 전';
    } else if (hours >= 6) {
        elapsedTime = '12시간 전';
    } else if (hours >= 3) {
        elapsedTime = '6시간 전';
    } else if (hours >= 1) {
        elapsedTime = '3시간 전';
    } else {
        elapsedTime = '1시간 미만';
    }


    const elapsedTimeElement = communityTimeElement.querySelector('.elapsed-time');
    elapsedTimeElement.textContent = elapsedTime;
}










